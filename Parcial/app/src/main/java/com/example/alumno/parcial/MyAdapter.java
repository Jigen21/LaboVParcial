package com.example.alumno.parcial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by alumno on 09/05/2019.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
{

    private List<Productos> productos;
    MyOnItemListener listener;

    public MyAdapter(List<Productos> productos,MyOnItemListener listener)
    {
        this.listener=listener;
        this.productos = productos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(v,listener);

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Productos p=this.productos.get(position);
        holder.nombre.setText("Nombre  :" +p.getNombre());
        holder.cantidad.setText("Cantidad : " +p.getCantidad());
        holder.precio.setText("Precio :" +p.getPrecio());



        holder.setPosition(position);


    }

    @Override
    public int getItemCount()
    {
        return this.productos.size();
    }

    public void setProductos(List<Productos> productos)
    {
        this.productos = productos;
    }

    public List<Productos> getProductos() {
        return productos;
    }
}
