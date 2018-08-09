package com.example.android.inventoryapp.data;

import android.provider.BaseColumns;

public final class InventoryContract {

    private InventoryContract() {

    }

    public static abstract class InventoryEntry implements BaseColumns {

        public final static String TABLE_NAME = "books";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_PRODUCT_NAME = "name";

        public final static String COLUMN_PRICE = "price";

        public final static String COLUMN_QUANTITY = "quantity";

        public final static String COLUMN_SUPPLIER_NAME = "supplier_name";

        public final static String COLUMN_PHONE = "phone";

    }
}

