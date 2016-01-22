package co.ommu.phonebroke;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import co.ommu.phonebroke.adapter.CiriAdapter;
import co.ommu.phonebroke.models.CiriModel;

public class MainActivity extends Activity implements View.OnClickListener {

    public ArrayList<CiriModel> array = new ArrayList<CiriModel>();
    protected SQLiteDatabase db;
    protected Cursor cursor;
    protected CiriAdapter adapter;
    ListView lvCiri;
    Button btnCompare;
    ArrayList<String> arrayId = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = (new DatabaseHelper(this)).getWritableDatabase();

        btnCompare = (Button) findViewById(R.id.buttonCompare);
        btnCompare.setOnClickListener(this);

        //MyStateSaver data = (MyStateSaver) getLastNonConfigurationInstance();
        //if (data != null) {

        //} else {

        //}
        getListData();
    }

    private void buildWidget() {
        lvCiri = (ListView) findViewById(R.id.listCiri);

        /*
        adapter = new SimpleCursorAdapter(this, R.layout.view_ciri, cursor,
                new String[] { "ciri" },
                new int[] { R.id.textCiri});
        lvCiri.setAdapter(adapter);
        */

        adapter = new CiriAdapter(array, getApplicationContext());
        lvCiri.setAdapter(adapter);

        /*
        lvCiri.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
               // startActivity(new Intent(getApplicationContext(), ResultDetailActivity.class)
               //         .putExtra("id", array.get(arg2).id)
               //         .putExtra("loc", array.get(arg2).location));
                Log.i("tes id", arrayId.get(arg2));
            }
        });
        */

    }

    private void getListData() {
        String query = "SELECT * FROM pakar_ciri";
        cursor = db.rawQuery(query, null);
        arrayId = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                CiriModel item = new CiriModel();
                item.id = cursor.getString(0);
                item.ciri = cursor.getString(1);
                //Log.i("id", item.id +" "+item.ciri);
                arrayId.add(item.id);
                array.add(item);
            } while
                (cursor.moveToNext());
        }
        buildWidget();
    }


    @Override
    public void onClick(View arg0) {
        int id = arg0.getId();

        if (id == R.id.buttonCompare) {
            // TODO Auto-generated method stub
            /*
            Intent intent = new Intent(getBaseContext(), ResultActivity.class);
            keyword = fieldSearch.getText().toString();
            if (keyword != null && keyword.length() > 0) {
                intent.putExtra("url", searching[selected] + "/" + keyword);
                intent.putExtra("keyword", keyword);
                startActivity(intent);
                fieldSearch.getText().clear();
            } else
                Toast.makeText(getBaseContext(), "Pencarian tidak boleh kosong", Toast.LENGTH_SHORT).show();
            */
        }
    }

}
