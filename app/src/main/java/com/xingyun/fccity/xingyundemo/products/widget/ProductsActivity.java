package com.xingyun.fccity.xingyundemo.products.widget;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.xingyun.fccity.xingyundemo.R;
import com.xingyun.fccity.xingyundemo.adapter.EfficientAdapter;
import com.xingyun.fccity.xingyundemo.adapter.ProductsAdapter;
import com.xingyun.fccity.xingyundemo.beans.ProductsBean;
import com.xingyun.fccity.xingyundemo.listener.EndlessRecyclerOnScrollListener;
import com.xingyun.fccity.xingyundemo.login.widget.LoginActivity;
import com.xingyun.fccity.xingyundemo.products.presenter.ProductsPreseneterImpl;
import com.xingyun.fccity.xingyundemo.products.presenter.ProductsPresenter;
import com.xingyun.fccity.xingyundemo.products.view.ProductsView;
import com.xingyun.fccity.xingyundemo.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fccity on 16/7/12.
 */

public class ProductsActivity extends AppCompatActivity implements ProductsView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recycle_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh_widget)
    SwipeRefreshLayout swipeRefreshWidget;

    private LinearLayoutManager mLayoutManager;
    private ProductsPresenter mProductsPresenter;
    private ProductsAdapter mProductsAdapter;
    private List<ProductsBean> mData = new ArrayList<ProductsBean>();

    /**
     * 当前页码
     */
    private int pageIndex = 0;
    /**
     * 退出应用计时参数
     */
    private long mExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productslist);
        ButterKnife.bind(this);
        initView();
        initData();

        onRefresh();
    }

    private void initView() {
        swipeRefreshWidget.setColorSchemeResources(R.color.primary,
                R.color.primary_dark, R.color.primary_light,
                R.color.accent);
        swipeRefreshWidget.setOnRefreshListener(this);

    }

    private void initData() {
        if (!SharedPreferencesUtil.getData(ProductsActivity.this, "isLogin", false))
            startActivity(new Intent(ProductsActivity.this, LoginActivity.class));

        mProductsPresenter = new ProductsPreseneterImpl(this);

        mLayoutManager = new LinearLayoutManager(ProductsActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                Log.e("city", "mData.size() is:" + mData.size());
                if (mData.size() > 8)
                    simulateLoadMoreData();
            }
        });

        mProductsAdapter = new ProductsAdapter(mData);
        mProductsAdapter.setOnItemClickListener(new EfficientAdapter.OnItemClickListener<ProductsBean>() {
            @Override
            public void onItemClick(EfficientAdapter<ProductsBean> adapter, View view, ProductsBean object, int position) {
                startActivity(new Intent(ProductsActivity.this, ProductsDetailActivity.class).putExtra("products", object));
            }
        });

        mRecyclerView.setAdapter(mProductsAdapter);
    }

    private void simulateLoadMoreData() {
        pageIndex++;
        swipeRefreshWidget.setRefreshing(true);
        Handler handler = new Handler();
        Runnable updateThread = new Runnable() {
            public void run() {
                mProductsPresenter.loadProducts(pageIndex);
            }

        };
        handler.postDelayed(updateThread, 1500);
    }

    @Override
    public void onRefresh() {
        pageIndex = 0;
        if (mData != null) {
            mData.clear();
        }
        mProductsPresenter.loadProducts(pageIndex);
    }

    @Override
    public void showProgress() {
        swipeRefreshWidget.setRefreshing(true);
    }

    @Override
    public void addProducts(List<ProductsBean> productsList) {
        if (mData == null) {
            mData = new ArrayList<ProductsBean>();
        }
        mData.addAll(productsList);

        mProductsAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgress() {
        swipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public void showLoadFailMsg() {

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(ProductsActivity.this, "再点一次退出", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();

            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
