/**
 * @(#)Stock.java, Oct 27, 2022.
 * <p>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nus.cs5424.storage;

import com.nus.cs5424.data.Stock;

import java.util.List;

/**
 * @author guochenghui
 */
public interface StockStorage {

    Stock query(int s_w_id, int s_i_id);

    Integer getNumOfItemBelowThresholdByWarehouse(int s_w_id, List<Integer> item_ids, int threshold);
}