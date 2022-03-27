package com.leetcode.problems.tree.binarytree.topkfrequent;

import sun.plugin.com.BeanClass;

import java.util.*;

/**
 * @Author Duole
 * @Version 1.0
 */
public class Lc692 {
    public static void main(String[] args) {
//        String[] arr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
//        Solution solution = new Solution();
//        System.out.println(solution.topKFrequent(arr, 4));

        //String[] arr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(arr, 2));


        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(9);
        list.add(8);
        list.add(7);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);
    }
}

class Solution {
    //使用hashmap+大顶堆
    public List<String> topKFrequent(String[] words, int k) {
        List<String> resultList = new ArrayList<>();
        //单词-频次 map
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        //此处的排序规则非常重要：  当o1和o2对应的频次相等的时候，比较字母顺序；当o1和o2对应的频次不相等的时候，比较频次大小
        PriorityQueue<String> maxHeap = new PriorityQueue<>(words.length, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2)) {
                    return o1.compareTo(o2);
                } else {
                    return map.get(o2) - map.get(o1);
                }
            }
        });
        for (String word : map.keySet()) {
            maxHeap.add(word);
        }
        int count = 0;
        while (!maxHeap.isEmpty()) {
            count++;
            resultList.add(maxHeap.poll());
            if (count == k) {
                break;
            }
        }
        return resultList;
    }

    //使用hashmap硬编码
    public List<String> topKFrequent1(String[] words, int k) {
        List<String> resultList = new ArrayList<>();
        //单词-频次 map
        Map<String, Integer> map = new HashMap<>();
        //频次-单词列表 map，但是此时的单词列表未排序
        Map<Integer, ArrayList> preMap = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String key : map.keySet()) {
            //出现频次
            int times = map.get(key);
            if (!preMap.containsKey(times)) {
                ArrayList list = new ArrayList();
                list.add(key);
                preMap.put(times, list);
            } else {
                preMap.get(times).add(key);
            }
        }

        for (Integer key : preMap.keySet()) {
            preMap.get(key).sort(Comparator.naturalOrder());
        }

        List<Integer> mapKeys = new ArrayList<>(preMap.keySet());
        Collections.sort(mapKeys, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;  //降序。需要升序则是o1-o2
            }
        });
        //向resultList中添加的元素，最多k个
        int count = 0;
        //preMap : {1=[coding, leetcode], 2=[i, love]}
        //mapKeys : [2, 1]
        for (int i = 0; i < mapKeys.size(); i++) {
            ArrayList<String> sortedStringList = preMap.get(mapKeys.get(i));
            for (String word : sortedStringList) {
                resultList.add(word);
                if (++count == k) {
                    return resultList;
                }
            }
        }
        return resultList;
    }
}

