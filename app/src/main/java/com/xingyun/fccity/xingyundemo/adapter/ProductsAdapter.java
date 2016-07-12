package com.xingyun.fccity.xingyundemo.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xingyun.fccity.xingyundemo.R;
import com.xingyun.fccity.xingyundemo.beans.ProductsBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fccity on 16/7/12.
 */

public class ProductsAdapter extends EfficientRecyclerAdapter<ProductsBean> {

    public ProductsAdapter(List<ProductsBean> objects) {
        super(objects);
    }

    @Override
    public int getLayoutResId(int viewType) {
        return R.layout.product_list_item;
    }

    @Override
    public Class<? extends EfficientViewHolder<? extends ProductsBean>> getViewHolderClass(int viewType) {
        return ProductListViewHolder.class;
    }

    public class ProductListViewHolder extends EfficientViewHolder<ProductsBean> {

        @Bind(R.id.product_iv)
        ImageView productIv;
        @Bind(R.id.product_name)
        TextView productName;
        @Bind(R.id.product_memo)
        TextView productMemo;
        @Bind(R.id.product_price)
        TextView productPrice;
        @Bind(R.id.product_unitprice)
        TextView productUnitprice;
        @Bind(R.id.product_marketprice)
        TextView productMarketprice;

        public ProductListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void updateView(Context context, ProductsBean productsBean) {

            if (!TextUtils.isEmpty(productsBean.getName()))
                productName.setText(productsBean.getName());
            if (!TextUtils.isEmpty(productsBean.getMarketprice()))
                productMarketprice.setText(productsBean.getMarketprice());
            productMarketprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        }
    }
}
