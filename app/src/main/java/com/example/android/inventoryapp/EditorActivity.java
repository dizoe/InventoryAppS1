package com.example.android.inventoryapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.inventoryapp.data.DbHelper;
import com.example.android.inventoryapp.data.InventoryContract.InventoryEntry;

public class EditorActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mPriceEditText;
    private EditText mQuantityEditText;
    private EditText mSupplierNameEditText;
    private EditText mPhoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        mNameEditText = (EditText) findViewById(R.id.product_name_edit_text);
        mPriceEditText = (EditText) findViewById(R.id.price_edit_text);
        mQuantityEditText = (EditText) findViewById(R.id.quantity_edit_text);
        mSupplierNameEditText = (EditText) findViewById(R.id.product_supplier_name_edit_text);
        mPhoneEditText = (EditText) findViewById(R.id.phone_edit_text);
    }

    int getIntSafe(String txt) {

        int ret = 0;
        try {
            ret = Integer.parseInt(txt);
        } catch (NumberFormatException ex) {
        }

        return ret;
    }

    private void insertBook() {


        String nameString = mNameEditText.getText().toString().trim();

        String priceString = mPriceEditText.getText().toString().trim();
        int price = getIntSafe(priceString);
        try {
            price = Integer.parseInt(priceString);
        } catch (NumberFormatException ex) {
        }

        String quantityString = mQuantityEditText.getText().toString().trim();
        int quantity = getIntSafe(quantityString);
        try {
            quantity = Integer.parseInt(priceString);
        } catch (NumberFormatException ex) {
        }

        String supplierNameString = mSupplierNameEditText.getText().toString().trim();

        String phoneString = mPhoneEditText.getText().toString().trim();
        int supplierPhone = getIntSafe(phoneString);
        try {
            supplierPhone = getIntSafe(phoneString);
        } catch (NumberFormatException ex) {
        }


        DbHelper mDbHelper = new DbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(InventoryEntry.COLUMN_PRODUCT_NAME, nameString);


        values.put(InventoryEntry.COLUMN_PRICE, price);


        values.put(InventoryEntry.COLUMN_QUANTITY, quantity);


        values.put(InventoryEntry.COLUMN_SUPPLIER_NAME, supplierNameString);


        values.put(InventoryEntry.COLUMN_PHONE, supplierPhone);


        long newRowId = db.insert(InventoryEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(this, getString(R.string.error_saving), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.item_saved) + newRowId, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                insertBook();
                finish();
                return true;

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
