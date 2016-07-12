package com.xingyun.fccity.xingyundemo.products.widget;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xingyun.fccity.xingyundemo.R;
import com.xingyun.fccity.xingyundemo.beans.ProductsBean;
import com.xingyun.fccity.xingyundemo.beans.ProductsDetailsBean;
import com.xingyun.fccity.xingyundemo.products.presenter.ProductsDetailPresenter;
import com.xingyun.fccity.xingyundemo.products.presenter.ProductsDetailPresenterImpl;
import com.xingyun.fccity.xingyundemo.products.view.ProductsDetailView;
import com.xingyun.fccity.xingyundemo.utils.ToolsUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by fccity on 16/7/12.
 */

public class ProductsDetailActivity extends SwipeBackActivity implements ProductsDetailView {
    @Bind(R.id.ivImage)
    ImageView ivImage;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.progress)
    ProgressBar progress;
    @Bind(R.id.product_name)
    TextView productName;
    @Bind(R.id.product_norm)
    TextView productNorm;
    @Bind(R.id.product_grade)
    TextView productGrade;
    @Bind(R.id.product_store)
    TextView productStore;
    @Bind(R.id.product_ppr)
    TextView productPpr;

    private SwipeBackLayout mSwipeBackLayout;
    private ProductsBean mProducts;
    private ProductsDetailPresenter mProductsDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_detail);
        ButterKnife.bind(this);

        mProducts = (ProductsBean) getIntent().getSerializableExtra("products");

        collapsingToolbar.setTitle(mProducts.getName());
        collapsingToolbar.setCollapsedTitleTextColor(R.color.white);
        ivImage.setImageResource(R.mipmap.chile_green_snake_fruit);

        mProductsDetailPresenter = new ProductsDetailPresenterImpl(this);
        mProductsDetailPresenter.loadProductsDetail(mProducts.getPid());

        setSwipeBackEnable(true);
    }

    @Override
    public void showProductsDetialContent(ProductsDetailsBean mProductsBean) {
        Log.e("city", "the product's grade is" + mProductsBean.getGrade());
        productName.setText("品名:" + mProducts.getName());
        productNorm.setText("规格:" + mProductsBean.getNorm());
        productGrade.setText("等级:" + mProductsBean.getGrade());
        productStore.setText("储存:" + mProductsBean.getStore());
        productPpr.setText("性价比:" + mProductsBean.getPpr());
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);

    }
}
