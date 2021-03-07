package com.example.chapter7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] animals={
            R.drawable.cat4,
            R.drawable.cub2,
            R.drawable.deer8,
            R.drawable.jir1,
            R.drawable.monkey10,
            R.drawable.wolf9};

    ImageView largePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid=(GridView)findViewById(R.id.gridView);
        final ImageView largePic=(ImageView)findViewById(R.id.imageLarge);
        grid.setAdapter(new ImageAdapter(this));// we are creating an image adapter inside the grid
        //a context just ensures that we know which of our app's screens we are talking about
        // what do we mean by "this" what are we passing exactly ?
        // How does the code know which picture the user clicks on ?
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),("Selected species "+position+1),Toast.LENGTH_LONG).show();
                largePic.setImageResource(animals[position]);

            }
        });


    }
    public class ImageAdapter extends BaseAdapter {
        private Context context; //transfer objects to what I want

        public ImageAdapter(Context c){
            context=c;
        }


        @Override
        public int getCount() {
            return animals.length;
        }

        @Override
        public Object getItem(int position) {
            return position;//null
        }

        @Override
        public long getItemId(int position) {
            return position;//0
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            largePic=new ImageView(context);
            largePic.setImageResource(animals[position]);
            largePic.setScaleType(ImageView.ScaleType.FIT_XY);
            largePic.setLayoutParams(new ViewGroup.LayoutParams(300,300));

            return largePic;
        }
    }
}