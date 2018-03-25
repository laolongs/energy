package tties.cn.energy.view.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

/**
 * Created by li on 2018/3/12
 * description：
 * author：guojlli
 */

public class MyViewPageAdapter extends PagerAdapter implements Serializable {
    private List<View> views;

    public MyViewPageAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewGroup parent = (ViewGroup) views.get(position).getParent();
        if (parent != null) {
            parent.removeAllViews();
        }
        container.addView(views.get(position), 0);
        return views.get(position);
    }
}