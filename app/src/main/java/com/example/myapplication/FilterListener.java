package com.example.myapplication;
 
import java.util.List;
/**
 * 接口类，抽象方法用来获取过滤后的数据
 * @author liuli
 *
 */
public interface FilterListener {
    void getFilterData(List<String> list);// 获取过滤后的数据
}