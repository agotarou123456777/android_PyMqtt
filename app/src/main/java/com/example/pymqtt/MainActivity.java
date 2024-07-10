package com.example.pymqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btPython = findViewById(R.id.btPython);
        btPython.setOnClickListener(new GetPythonText());
    }

    private class GetPythonText implements View.OnClickListener{
        @Override
        public void onClick(View view){

            Python py = Python.getInstance();
            PyObject module = py.getModule("test");
            String pyText = module.callAttr("PyHello").toString();
            Log.d("python", pyText);

            //クラスはPyObjectで受け取る
            PyObject pyclass = module.callAttr("SampleClass");
            Integer pyVal = pyclass.callAttr("get_val").toInt();
            Log.d("python", pyVal.toString());

            //setメソッドでメンバ書き換え
            pyclass.callAttr("set_val", 100);
            pyVal = pyclass.callAttr("get_val").toInt();
            Log.d("python", pyVal.toString());

            //mqtt
            module.callAttr("mqtt_test");

        }
    }
}