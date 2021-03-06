package tties.cn.energy.view;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.hjm.bottomtabbar.BottomTabBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tties.cn.energy.R;
import tties.cn.energy.base.BaseActivity;
import tties.cn.energy.common.Constants;
import tties.cn.energy.model.result.Versionbean;
import tties.cn.energy.presenter.MainPresenter;
import tties.cn.energy.utils.ACache;
import tties.cn.energy.view.activity.UpdateActivity;
import tties.cn.energy.view.fragment.DataFragment;
import tties.cn.energy.view.fragment.EnergyFragment;
import tties.cn.energy.view.fragment.IdentityFragment;
import tties.cn.energy.view.fragment.OpsFragment;
import tties.cn.energy.view.iview.IMainView;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    //    @BindView(R.id.view_pager)
//    ViewPager viewPager;
//    @BindView(R.id.magic_indicator)
//    MagicIndicator magicIndicator;
//    private static final String TEXT_ARRAY[] = new String[]{"运维", "能效", "数据", "我的"};
//    private static final String ID_ARRAY[] = new String[]{"OpsActivity", "EnergyActivity", "DataActivity", "IdentityActivity", "IdentityActivity"};
//    private int IMAGE_ARRAY[] = {R.mipmap.ic_home, R.mipmap.ic_monitor, R.mipmap.ic_analysis, R.mipmap.ic_statement};
//    private int IMAGE_ARRAY_SEL[] = {R.mipmap.ic_home_sel, R.mipmap.ic_monitor_sel, R.mipmap.ic_analysis_sel, R.mipmap.ic_statement_sel};
//    LocalActivityManager manager = null;
//    @BindView(R.id.main_fl)
//    FrameLayout mainFl;
    @BindView(R.id.main_bottom_tab_bar)
    BottomTabBar mainBottomTabBar;
    private List<View> mViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initVIewtwo();
        checkVersion();
    }
    @Override
    protected void createPresenter() {
        mPresenter = new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public void initVIewtwo(){
        mainBottomTabBar.init(getSupportFragmentManager())
                //参数1：选中后的颜色，参数2：选中前的颜色
                .setChangeColor(Color.RED, Color.DKGRAY)
                //参数1：文字内容。参数2：导航图片。参数3：切换哪个fragment类
                .addTabItem("运维",R.mipmap.ic_home, OpsFragment.class)
                .addTabItem("能效",R.mipmap.ic_monitor, EnergyFragment.class)
                .addTabItem("数据",R.mipmap.ic_analysis, DataFragment.class)
                .addTabItem("我的",R.mipmap.ic_statement, IdentityFragment.class)
                //是否显示导航和上边的fragment的区分线(黑色的线太难看了一般我不喜欢在那里设)
                //false为不显示那条区分线，true为显示那条区分线
                .isShowDivider(true);
    }

    @Override
    public void setViewPageData(List<View> list) {
    }
    private void checkVersion() {
        try {
            Versionbean ret = ACache.getInstance().getAsObject(Constants.CACHEE_VERSION);
            if (ret == null) {
                return;
            }
            // 获取packagemanager的实例
            PackageManager packageManager = getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(), 0);
            int versionCode = packInfo.versionCode;
            if (ret.getVersionCode() > versionCode) {
                UpdateActivity.show(MainActivity.this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
