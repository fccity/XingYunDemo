package com.xingyun.fccity.xingyundemo.products.view;

import com.xingyun.fccity.xingyundemo.beans.ProductsBean;

import java.util.List;

/**
 * Created by fccity on 16/7/12.
 */

public interface ProductsView {
    void showProgress();

    void addProducts(List<ProductsBean> productsList);

    void hideProgress();

    void showLoadFailMsg();
}
