package com.home.joke;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bean.MainItemBean;
import com.example.dveeale.sharkmvpdemo.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.network.Urls;
import com.refreshview.recyclerview.BaseRecyclerAdapter;
import com.util.ControllerListenerUtil;
import com.util.DpPxConvert;
import com.util.MyUtils;
import com.util.StringUtil;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/11/9 14:52
 * Email: fanyafeng@live.cn
 */
public class JokeAdapter extends BaseRecyclerAdapter<JokeAdapter.MainViewHolder> {

    private Context context;
    private List<MainItemBean> mainItemBeanList;

    public JokeAdapter(Context context) {
        this.context = context;
    }

    public void SetDataList(List<MainItemBean> mainItemBeanList){
        this.mainItemBeanList = mainItemBeanList;
    }

    @Override
    public MainViewHolder getViewHolder(View view) {
        return new MainViewHolder(view);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_joke_layout, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position, boolean isItem) {
        MainViewHolder mainViewHolder = holder;
        final MainItemBean mainItemBean = mainItemBeanList.get(position);
        mainViewHolder.tvMainItem.setText(mainItemBean.getContent());
        if (!StringUtil.isNullOrEmpty(mainItemBean.getImage()) && !mainItemBean.getImage().equalsIgnoreCase("null")) {
            mainViewHolder.sdvMainItem.setVisibility(View.VISIBLE);
            final String img = Urls.PICTURE_ITEM + String.valueOf(mainItemBean.getId()).substring(0, 5) + "/" + mainItemBean.getId() + "/medium/";
            ControllerListenerUtil.setControllerListener(mainViewHolder.sdvMainItem, img + mainItemBean.getImage(),
                    (int) (MyUtils.getScreenWidth(context) - DpPxConvert.dip2px(context, 60)));
            mainViewHolder.sdvMainItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    ArrayList<String> list = new ArrayList<String>();
//                    list.add(img + mainItemBean.getImage());
//                    Intent intent = new Intent(context, PreviewActivity.class);
//                    intent.putStringArrayListExtra("list", list);
//                    context.startActivity(intent);
                }
            });
        } else {
            mainViewHolder.sdvMainItem.setVisibility(View.GONE);
        }
    }

    @Override
    public int getAdapterItemCount() {
        int size=0;
        if(mainItemBeanList!=null&&mainItemBeanList.size()>0){
            size=mainItemBeanList.size();
        }
        return size;
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        TextView tvMainItem;
        SimpleDraweeView sdvMainItem;

        public MainViewHolder(View itemView) {
            super(itemView);
            tvMainItem = (TextView) itemView.findViewById(R.id.tvMainItem);
            sdvMainItem = (SimpleDraweeView) itemView.findViewById(R.id.sdvMainItem);
        }
    }
}
