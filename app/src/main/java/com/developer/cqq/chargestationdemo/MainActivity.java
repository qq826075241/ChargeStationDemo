package com.developer.cqq.chargestationdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import lecho.lib.hellocharts.model.*;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.LineChartView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ColumnChartView mColumnChartView;
    private LineChartView mLineChartView;
    private Button chart1;
    private Button chart2;
    private Button rangeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mColumnChartView = (ColumnChartView) findViewById(R.id.chart1);
        mLineChartView = (LineChartView) findViewById(R.id.chart2);

        chart1 = (Button) findViewById(R.id.chart1Str);
        chart2 = (Button) findViewById(R.id.chart2Str);
        rangeData = (Button) findViewById(R.id.rangeData);

        setColumnChartData();
        setLineChartData();

        mColumnChartView.setVisibility(View.VISIBLE);
        mLineChartView.setVisibility(View.INVISIBLE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        chart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColumnChartView.setVisibility(View.VISIBLE);
                mLineChartView.setVisibility(View.INVISIBLE);
            }
        });

        chart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColumnChartView.setVisibility(View.INVISIBLE);
                mLineChartView.setVisibility(View.VISIBLE);
            }
        });

        rangeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColumnChartView.setVisibility(View.VISIBLE);
                mLineChartView.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setColumnChartData() {
        List<Column> columnList = new ArrayList<>(); //柱子列表
        List<SubcolumnValue> subcolumnValueList;     //子柱列表（即一个柱子，因为一个柱子可分为多个子柱）
        for (int i = 0; i < 7; ++i) {
            subcolumnValueList = new ArrayList<>();
            subcolumnValueList.add(new SubcolumnValue((float) Math.random() * 50f, ChartUtils.pickColor()));

            Column column = new Column(subcolumnValueList);
            columnList.add(column);
        }

        ColumnChartData mColumnChartData = new ColumnChartData(columnList);
        mColumnChartView.setColumnChartData(mColumnChartData);
    }

    public void setLineChartData() {

        /**
         * 简单模拟的数据
         */
        List<PointValue> values = new ArrayList<>();
        values.add(new PointValue(0, 3));
        values.add(new PointValue(1, 1));
        values.add(new PointValue(2, 4));
        values.add(new PointValue(3, 0));
        //setCubic(true),true是曲线型，false是直线连接
        Line line = new Line(values).setColor(Color.BLUE).setCubic(true);
        List<Line> lines = new ArrayList<>();
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);
        Axis axisX = new Axis();
        //setHasLines(true),设定是否有网格线
        Axis axisY = new Axis().setHasLines(false);
        //为两个坐标系设定名称
        axisX.setName("Axis X");
        axisY.setName("Axis Y");
        //设置图标所在位置
        data.setAxisXBottom(axisX);
        data.setAxisYLeft(axisY);
        //将数据添加到View中
        mLineChartView.setLineChartData(data);
    }
}

/**

 算法
 时间成本 a    里程成本 b


 */
















