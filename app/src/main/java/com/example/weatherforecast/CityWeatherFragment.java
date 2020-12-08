package com.example.weatherforecast;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CityWeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CityWeatherFragment extends BaseFragment implements View.OnClickListener {
    TextView tempTv,cityTv,conditionTv,windTv,tempRangeTv,dateTv,clothIndexTv,carIndexTv,coldIndexTv,sportIndexTv,uvIndexTv;
//    当天天气情况
    ImageView dayTv;
//    未来三天天气情况
    LinearLayout futureLayout;
//    地址 从地址进行切割
    String url1="http://api.map.baidu.com/telematics/v3/weather?location=";
    String url2="&output=json&ak=FkPhtMBKOHTIQNh7gG4cNUttSTyr0nzo";


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CityWeatherFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CityWeatherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CityWeatherFragment newInstance(String param1, String param2) {
        CityWeatherFragment fragment = new CityWeatherFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city_weather, container, false);
        initView(view);
//        可以通过activity传值获取到当期fragment加载的是哪个地方的天气情况
        Bundle bundle = getArguments();
        String city = bundle.getString("city");
        String url = url1+city+url2;
//      调用父类获取数据的方法
        loadData(url);
        return view;
    }
//    多态 继承


    @Override
    public void onSuccess(String result) {
        super.onSuccess(result);
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
//        解析并展示数据
        
    }

    private void initView(View view) {
//        用于初始化控件
        tempTv = view.findViewById(R.id.frag_tv_current);
        cityTv = view.findViewById(R.id.frag_tv_city);
        conditionTv = view.findViewById(R.id.frag_tv_condition);
        windTv =view.findViewById(R.id.frag_tv_wind);
        tempRangeTv = view.findViewById(R.id.frag_tv_tmprange);
        dateTv = view.findViewById(R.id.frag_tv_date);
        clothIndexTv = view.findViewById(R.id.frag_index_tv_dress);
        carIndexTv = view.findViewById(R.id.frag_index_tv_car);
        coldIndexTv = view.findViewById(R.id.frag_index_tv_cold);
        sportIndexTv = view.findViewById(R.id.frag_index_tv_sport);
        uvIndexTv = view.findViewById(R.id.frag_index_tv_uv);
        dayTv = view.findViewById(R.id.frag_tv_today);
        futureLayout = view.findViewById(R.id.frag_center_layout);
//      设置点击事件监听
        clothIndexTv.setOnClickListener(this);
        carIndexTv.setOnClickListener(this);
        coldIndexTv.setOnClickListener(this);
        sportIndexTv.setOnClickListener(this);
        uvIndexTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        监听中进行查找
        switch (view.getId()){
            case R.id.frag_index_tv_dress:

                break;
            case R.id.frag_index_tv_car:

                break;
            case R.id.frag_index_tv_cold:

                break;
            case R.id.frag_index_tv_sport:

                break;
            case R.id.frag_index_tv_uv:

                break;

        }

    }
}