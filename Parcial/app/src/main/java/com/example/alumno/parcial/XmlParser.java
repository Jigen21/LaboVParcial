package com.example.alumno.parcial;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 09/05/2019.
 */

public class XmlParser
{
    public static List<Productos> traerXml(String s) throws XmlPullParserException, IOException {

        List<Productos> productos = new ArrayList<Productos>();
        XmlPullParser parser = Xml.newPullParser();

        String nombre="";
        String precio="";
        String cantidad="";
        String id="";
        Productos p=new Productos("","","","");


        parser.setInput(new StringReader(s));

        int event=parser.getEventType();

        while(event!=XmlPullParser.END_DOCUMENT)
        {
            switch(event)
            {
                case XmlPullParser.START_TAG:

                    if("producto".equals(parser.getName()))
                    {
                        p = new Productos(nombre,precio,cantidad,id);

                    }

                    if("id".equals(parser.getName()))
                    {
                        //id=parser.nextText();
                        p.setId(parser.nextText());


                    }
                    if("nombre".equals(parser.getName()))
                    {
                       // nombre=parser.nextText();
                        p.setNombre(parser.nextText());


                    }
                    if("precio".equals(parser.getName()))
                    {
                      //  precio=parser.nextText();
                        p.setPrecio(parser.nextText());


                    }
                    if("cantidad".equals(parser.getName()))
                    {
                        //cantidad=parser.nextText();
                        p.setCantidad(parser.nextText());
                        productos.add(p);


                    }


                    //event=parser.next();


                    // Productos p = new Productos(id,nombre,precio,cantidad);

                     //productos.add(p);



                    //productos.add(p);

            }

          //  Productos p = new Productos(id,nombre,precio,cantidad);

           // productos.add(p);
            event=parser.next();
           // productos.add(p);





        }


        return productos;


    }

}
