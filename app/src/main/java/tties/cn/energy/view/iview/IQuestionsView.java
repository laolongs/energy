package tties.cn.energy.view.iview;



import android.support.v4.app.Fragment;

import java.util.List;

import tties.cn.energy.base.BaseView;

/**
 * Created by li on 2018/3/23
 * description：
 * author：guojlli
 */

public interface IQuestionsView extends BaseView {
    public void setTabData(String[] array, List<Fragment> list);
//    public void setReplay();
}
