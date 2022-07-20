/*
 * 文件名称：ThreadSafe.java 系统名称：[系统名称] 模块名称：[模块名称] 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights
 * Reserved. 功能说明：[请在此处输入功能说明] 开发人员：Rushing0711 创建日期：20180323 08:32 修改记录： <Version> <DateSerial> <Author> <Description>
 * 1.0.0 20180323-01 Rushing0711 M201803230832 新建文件
 ********************************************************************************/
package com.coding.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 课程里用来标记【不推荐】的类或者写法.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotRecommend {

    String value() default "";
}
