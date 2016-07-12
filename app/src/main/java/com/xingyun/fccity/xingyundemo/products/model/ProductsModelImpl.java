package com.xingyun.fccity.xingyundemo.products.model;

import android.util.Log;

import com.xingyun.fccity.xingyundemo.beans.ProductsBean;
import com.xingyun.fccity.xingyundemo.beans.ProductsDetailsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fccity on 16/7/12.
 */

public class ProductsModelImpl implements ProductsModel {

    @Override
    public void loadProducts(String url, ProductsModelImpl.OnLoadProductsListListener listener) {
        List<ProductsBean> productsBeanList = new ArrayList<>();
        productsBeanList.add(new ProductsBean("0", "智利青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));
        productsBeanList.add(new ProductsBean("0", "意大利青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));
        productsBeanList.add(new ProductsBean("0", "荷兰青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));
        productsBeanList.add(new ProductsBean("0", "巴西青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));
        productsBeanList.add(new ProductsBean("0", "美国青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));
        productsBeanList.add(new ProductsBean("0", "阿根廷青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));
        productsBeanList.add(new ProductsBean("0", "巴西青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));
        productsBeanList.add(new ProductsBean("0", "西班牙青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));
        productsBeanList.add(new ProductsBean("0", "法国青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));
        productsBeanList.add(new ProductsBean("0", "德国青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));
        productsBeanList.add(new ProductsBean("0", "奥地利青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));
        productsBeanList.add(new ProductsBean("0", "比利时青蛇果", "每件5斤", "28.5/件", "4.8/斤", "市场价7.8/斤", ""));

        Log.e("city", "productBeanList size is:" + productsBeanList.size());

        listener.onSuccess(productsBeanList);
    }

    @Override
    public void loadProductsDetail(String pid, ProductsModelImpl.OnLoadProductsDetailListener listener) {
        ProductsDetailsBean productsDetailsBean = new ProductsDetailsBean("0", "", "一打(12个)", "一级果", "冷藏", "大小合适,香甜可口,营养价值极高。", "");
        listener.onSuccess(productsDetailsBean);
    }

    public interface OnLoadProductsListListener {
        void onSuccess(List<ProductsBean> list);

        void onFailure(String msg, Exception e);
    }

    public interface OnLoadProductsDetailListener {
        void onSuccess(ProductsDetailsBean productsDetailsBean);

        void onFailure(String msg, Exception e);
    }
}
