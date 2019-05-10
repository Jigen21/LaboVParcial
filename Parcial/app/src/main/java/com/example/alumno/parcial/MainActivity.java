package com.example.alumno.parcial;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback , MyOnItemListener {

    List<Productos> productos = new ArrayList<Productos>();

    MyOnItemListener listener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Handler h= new Handler(this);
        MyThread mt = new MyThread("http://192.168.2.166:8080/productos.xml",h);
        mt.start();

       /* Productos p = new Productos("2","ads","ads","dsa");
        Productos p2 = new Productos("2","ads","ads","dsa");
        this.productos.add(p);
        this.productos.add(p2);



        RecyclerView rv = (RecyclerView)findViewById(R.id.lista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        MyAdapter adapter = new MyAdapter(this.productos);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);

        */


    }

    @Override
    public boolean handleMessage(Message msg)
    {

        Log.d("LLEGUE","ASd");

        RecyclerView rv = (RecyclerView)findViewById(R.id.lista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        MyAdapter adapter = new MyAdapter((List<Productos>)msg.obj,this );
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        return true;
    }

    @Override
    public void OnClickListener(int position)
    {

        Log.d("Click","click");

    }
}
