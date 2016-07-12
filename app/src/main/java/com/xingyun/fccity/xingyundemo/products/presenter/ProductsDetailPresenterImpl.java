package com.xingyun.fccity.xingyundemo.products.presenter;

import com.xingyun.fccity.xingyundemo.beans.ProductsDetailsBean;
import com.xingyun.fccity.xingyundemo.products.model.ProductsModel;
import com.xingyun.fccity.xingyundemo.products.model.ProductsModelImpl;
import com.xingyun.fccity.xingyundemo.products.view.ProductsDetailView;

/**
 * Created by fccity on 16/7/12.
 */

public class ProductsDetailPresenterImpl implements ProductsDetailPresenter, ProductsModelImpl.OnLoadProductsDetailListener {

    private ProductsDetailView mProductsView;
    private ProductsModel mProductsModel;

    public ProductsDetailPresenterImpl(ProductsDetailView mProductsView) {
        this.mProductsView = mProductsView;
        this.mProductsModel = new ProductsModelImpl();
    }

    @Override
    public void loadProductsDetail(String pid) {
        mProductsView.showProgress();
        mProductsModel.loadProductsDetail(pid, this);
    }

    @Override
    public void onSuccess(ProductsDetailsBean productsDetailsBean) {
        if (productsDetailsBean != null) {
            mProductsView.showProductsDetialContent(productsDetailsBean);
        }
        mProductsView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mProductsView.showProgress();
    }
}
