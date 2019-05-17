package com.example.alumno.parcial;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback , MyOnItemListener {

    List<Productos> productos = new ArrayList<Productos>();

    MyOnItemListener listener;
    MyAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rv = (RecyclerView)findViewById(R.id.lista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MyAdapter(this.productos,this );
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
       // adapter.notifyDataSetChanged();






        Handler h= new Handler(this);
        MyThread mt = new MyThread("http://192.168.2.167:8080/a/productos.xml",h);
        //MyThread mt = new MyThread("http://192.168.0.20/Labov/productos.xml",h);
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

        /*RecyclerView rv = (RecyclerView)findViewById(R.id.lista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        MyAdapter adapter = new MyAdapter((List<Productos>)msg.obj,this );
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();*/


        this.productos=(List<Productos>)msg.obj;

        adapter.setProductos((List<Productos>)msg.obj);
        adapter.notifyDataSetChanged();


        return true;
    }

    @Override
    public void OnClickListener(int position,View v)
    {
            int i;
        if(v.getId()==R.id.sumar)
        {
            Log.d("ENTRE","G");
            i=Integer.valueOf(this.productos.get(position).getCantidad());
           // i=Integer.valueOf(adapter.getProductos().get(position).getCantidad());
            i=i+1;

           this.productos.get(position).setCantidad(String.valueOf(i));
            //this.adapter.getProductos().get(position).setCantidad(String.valueOf(i));
            adapter.notifyItemChanged(position);

            //this.productos.add(new Productos("asd","fds","gfdg","sdasad"));
            //adapter.notifyDataSetChanged();


        }

        if(v.getId()==R.id.restar)
        {
            i=Integer.valueOf(this.productos.get(position).getCantidad());
            i=i-1;
            if(i>=0)
            {

                this.productos.get(position).setCantidad(String.valueOf(i));
            }

            adapter.notifyItemChanged(position);
        }

      //  Log.d("Click","click");
        Log.d("click",this.productos.get(position).getNombre());

    }
}
