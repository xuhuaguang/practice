package com.rxlm.practice.java8.Stream;

import com.rxlm.practice.java8.bean.Dish;
import com.rxlm.practice.java8.bean.Trader;
import com.rxlm.practice.java8.bean.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * @Author: xz
 * @CreateDate: 2019/6/4 19:20
 * @Version: 1.0
 */
public class TestFindParam {

    public static void main(String[] args) {
        //领域：交易员和交易
        Trader raoul = new Trader("Zhangsan", "北京");
        Trader mario = new Trader("Lisi","上海");
        Trader alan = new Trader("Wangwu","北京");
        Trader brian = new Trader("Xuliu","北京");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        learn(transactions);
        //reduce();
    }

    /**
     * 何时使用findFirst和findAny 你可能会想，为什么会同时有findFirst和findAny呢？
     * 答案是并行。找到第一个元素 在并行上限制更多。如果你不关心返回的元素是哪个，
     * 请使用findAny，因为它在使用并行流 时限制较少
     */
    public static void testfindany() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst();
    }

    //查找元素
    public static void java8Find(List<Dish> menu) {
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d-> System.out.println(d.getName()));
    }

    //reduce规约
    public static void reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        //求和
        Integer reduce = numbers.stream().reduce(0, (a, b) -> a + b);
        Integer reduce1 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        System.out.println(reduce1);
        //求最大值
        Integer max = numbers.stream().reduce(0, Integer::max);
        System.out.println(max);
        //求最小值
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min.get());
    }


    public static void learn(List<Transaction> transactions) {
        long start = System.currentTimeMillis();
        //找出2011年发生的所有交易，并按交易额排序（从低到高）
        System.out.println("-------------找出2011年发生的所有交易，并按交易额排序（从低到高）-----------");
        List<Transaction> collect = transactions.stream().filter(t -> t.getYear() == 2011).
                sorted(comparing(Transaction::getValue)).collect(Collectors.toList());
        collect.forEach(tr-> System.out.println(tr.toString()));

        //交易员都在哪些不同的城市工作过？
        System.out.println();
        System.out.println("--------交易员都在哪些不同的城市工作过？---------");
        List<String> citys = transactions.stream().map(city -> city.getTrader().getCity()).distinct().collect(Collectors.toList());
        citys.forEach(c-> System.out.println(c));

        //查找所有来自于北京的交易员，并按姓名排序。
        System.out.println();
        System.out.println("---------查找所有来自于北京的交易员，并按姓名排序。-----------");
        //优化前
        List<Transaction> bjs = transactions.stream().
                filter(bj -> bj.getTrader().getCity().equals("北京")).
                distinct().
                sorted(comparing(name -> name.getTrader().getName())).collect(Collectors.toList());
        //优化后
        List<Trader> bj2 = transactions.stream().map(Transaction::getTrader).
                filter(trader -> trader.getCity().equals("北京")).
                distinct().
                sorted(comparing(Trader::getName)).collect(Collectors.toList());

        bj2.forEach(b-> System.out.println(b.toString()));

        //返回所有交易员的姓名字符串，按字母顺序排序。
        System.out.println();
        System.out.println("---------返回所有交易员的姓名字符串，按字母顺序排序。----------");
        //理解错误，正确意思是把姓名拼接在一个字符串
        List<String> string = transactions.stream().map(str -> str.getTrader().getName()).distinct().sorted().collect(Collectors.toList());
       //优化
        String strings = transactions.stream().map(name -> name.getTrader().getName()).distinct().sorted().collect(Collectors.joining());
        System.out.println(strings);

        //有没有交易员是在上海工作的？
        System.out.println();
        System.out.println("---------有没有交易员是在上海工作的？----------");
        boolean present = transactions.stream().map(cs -> cs.getTrader().getCity()).findAny().isPresent();
        System.out.println(present == true ? "有" : "没有");

        //打印生活在北京的交易员的所有交易额。
        System.out.println();
        System.out.println("---------打印生活在北京的交易员的所有交易额----------");
        Integer money = transactions.stream().filter(life -> life.getTrader().getCity().equals("北京")).map(Transaction::getValue).
                reduce(0, Integer::sum);
        System.out.println(money);

        //所有交易中，最高的交易额是多少？
        System.out.println();
        System.out.println("---------所有交易中，最高的交易额是多少？----------");
        Integer max = transactions.stream().map(Transaction::getValue).
                reduce(0, Integer::max);
        System.out.println(max);

        //所有交易中，最低的交易额是多少？
        System.out.println();
        System.out.println("---------所有交易中，最低的交易额是多少？----------");
        Optional<Integer> min = transactions.stream().map(Transaction::getValue).
                reduce(Integer::min);
        System.out.println(min.get());

        //优化
        Optional<Transaction> reduce = transactions.stream()
                .reduce((t1, t2) ->
                        t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(reduce.get());
        //流支持min和max方法，它们可以接受一个Comparator作为参数，指定
        //计算最小或最大值时要比较哪个键值
        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        .min(comparing(Transaction::getValue));


        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000 + "s");
    }

}
