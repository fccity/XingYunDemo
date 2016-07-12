package com.xingyun.fccity.xingyundemo.products.model;

/**
 * Created by fccity on 16/7/12.
 */

public interface ProductsModel {
    void loadProducts(String url, ProductsModelImpl.OnLoadProductsListListener listener);

    void loadProductsDetail(String pid, ProductsModelImpl.OnLoadProductsDetailListener listener);
}
