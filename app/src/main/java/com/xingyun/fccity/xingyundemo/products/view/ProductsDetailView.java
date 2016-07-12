package com.xingyun.fccity.xingyundemo.products.view;

import com.xingyun.fccity.xingyundemo.beans.ProductsDetailsBean;

/**
 * Created by fccity on 16/7/12.
 */

public interface ProductsDetailView {

    void showProductsDetialContent(ProductsDetailsBean mProductsBean);

    void showProgress();

    void hideProgress();

}
