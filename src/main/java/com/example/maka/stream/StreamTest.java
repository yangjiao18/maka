package com.example.maka.stream;

import cn.hutool.core.collection.CollUtil;
import com.example.maka.model.AnalysisModel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        list.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        ArrayList<String> strings1 = CollUtil.newArrayList("123", "212", "212");
        ArrayList<String> strings2 = CollUtil.newArrayList("abc", "qwe", "qbc");
        Stream.of(strings1, strings2).flatMap(Collection::stream).collect(Collectors.toList()).forEach(System.out::println);

        ArrayList<String> listStr = CollUtil.newArrayList("ABC", "DEF", "GHI");
        listStr.stream().flatMap(ele -> Stream.of(ele.split(""))).collect(Collectors.toList()).forEach(System.out::println);

    }
}
