package com.xingyun.fccity.xingyundemo.products.presenter;

import com.xingyun.fccity.xingyundemo.beans.ProductsBean;
import com.xingyun.fccity.xingyundemo.products.model.ProductsModel;
import com.xingyun.fccity.xingyundemo.products.model.ProductsModelImpl;
import com.xingyun.fccity.xingyundemo.products.view.ProductsView;

import java.util.List;

/**
 * Created by fccity on 16/7/12.
 */

public class ProductsPreseneterImpl implements ProductsPresenter, ProductsModelImpl.OnLoadProductsListListener {
    private ProductsView mProductsView;
    private ProductsModel mProductsModel;

    public ProductsPreseneterImpl(ProductsView productsView) {
        this.mProductsView = productsView;
        this.mProductsModel = new ProductsModelImpl();
    }

    @Override
    public void onSuccess(List<ProductsBean> list) {
        mProductsView.hideProgress();
        mProductsView.addProducts(list);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mProductsView.hideProgress();
        mProductsView.showLoadFailMsg();
    }

    @Override
    public void loadProducts(int page) {
        //只有第一页的或者刷新的时候才显示刷新进度条
        if (page == 0) {
            mProductsView.showProgress();
        }
        mProductsModel.loadProducts("", this);
    }
}
