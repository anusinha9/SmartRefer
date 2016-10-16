package com.example.aakash.smartrefer;
import java.util.ArrayList;

        import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
        import android.widget.ListView;
        import android.widget.Toast;

public class shoppinglist extends AppCompatActivity implements
        android.widget.CompoundButton.OnCheckedChangeListener {

    ListView lv;
    ArrayList<Planet> planetList;
    PlanetAdapter plAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleshoplist);

        lv = (ListView) findViewById(R.id.listview);
        displayPlanetList();
    }

    private void displayPlanetList() {

        planetList = new ArrayList<Planet>();
        planetList.add(new Planet("Tomato", 500));
        planetList.add(new Planet("Potato", 1000));
        planetList.add(new Planet("Jam", 2));
        planetList.add(new Planet("Rice", 5000));
        planetList.add(new Planet("Paneer", 500));
        planetList.add(new Planet("Milk", 500));
        planetList.add(new Planet("Dal", 2000));
        planetList.add(new Planet("Carrot", 100));
        planetList.add(new Planet("Cabbage", 300));

        plAdapter = new PlanetAdapter(planetList, this);
        lv.setAdapter(plAdapter);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        int pos = lv.getPositionForView(buttonView);
        if (pos != ListView.INVALID_POSITION) {
            Planet p = planetList.get(pos);
            p.setSelected(isChecked);

            Toast.makeText(
                    this,
                    "Selected Item: " + p.getName() + ". State: is "
                            + isChecked, Toast.LENGTH_SHORT).show();
        }
    }
}