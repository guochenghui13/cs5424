/**
 * @(#)Driver.java, Oct 29, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nus.cs5424.driver;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author guochenghui
 */
@Service
public class Driver {

    private static final String tx_file = "/Users/guochenghui/Desktop/编程资源-PDF文档.nosync/cs5424/project_files/xact_files/0.txt";

    public long doTransactions(){
        // 读取文件
        // 根据对应的标识调用对应的tx
        // 执行成功返回 + 1
        Scanner sc = null;
        try {
            sc = new Scanner(new File(tx_file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        long res = 0;

        while(sc.hasNext()){
            String[] args = sc.nextLine().split(",");
            String type = args[0];

            if (type.equals("N")) {
                int n = Integer.parseInt(args[args.length - 1]);
                List<String> orderLines = new ArrayList<String>();
                for (int i = 0; i < n; i++) {
                    orderLines.add(sc.nextLine());
                }
                String csv = String.join("\n", orderLines);

                List<String> argsList = new ArrayList<String>();
                for (String arg: args) {
                    argsList.add(arg);
                }
                argsList.add(csv);
                args = argsList.toArray(new String[argsList.size()]);
            }

            for (String s : args) System.out.print(s + " ");
            System.out.println();

            // TODO: 根据tx选择对应的内容
            switch (type) {
                case "N":
                    System.out.println("执行Order");
                default:
                    System.out.println("没有找到匹配的tx");
            }


            res++;
        }

        return res;
    }

}