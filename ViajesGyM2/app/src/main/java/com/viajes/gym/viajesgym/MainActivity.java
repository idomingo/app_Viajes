package com.viajes.gym.viajesgym;

    import android.app.Activity;
    import android.app.ListActivity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ArrayAdapter;
    import android.widget.ListView;

    /**
     * The launchpad activity for this sample project. This activity launches other activities that
     * demonstrate implementations of common animations.
     */
    public class MainActivity extends ListActivity {
        /**
         * This class describes an individual sample (the sample title, and the activity class that
         * demonstrates this sample).
         */
        private class Sample {
            private CharSequence title;
            private Class<? extends Activity> activityClass;

            public Sample(int titleResId, Class<? extends Activity> activityClass) {
                this.activityClass = activityClass;
                this.title = getResources().getString(titleResId);
            }

            @Override
            public String toString() {
                return title.toString();
            }
        }

        /**
         * The collection of all samples in the app. This gets instantiated in {@link
         * #onCreate(android.os.Bundle)} because the {@link Sample} constructor needs access to {@link
         * android.content.res.Resources}.
         */
        private static Sample[] mSamples;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Instantiate the list of samples.
            mSamples = new Sample[]{
                    new Sample(R.string.title_screen_slide, MainActivity.class),
                    new Sample(R.string.title_dia17, dia17.class),
                    new Sample(R.string.title_dia18, dia18.class),
                    new Sample(R.string.title_dia19, dia19.class),
                    new Sample(R.string.title_dia20, dia20.class),
                    new Sample(R.string.title_dia21, dia21.class),
					new Sample(R.string.title_dia22, dia22.class),
					new Sample(R.string.title_dia23, dia23.class),
					new Sample(R.string.title_dia24, dia24.class),
					new Sample(R.string.title_direcciones, direcciones.class),
                    new Sample(R.string.title_budget, presupuesto.class),
            };

            setListAdapter(new ArrayAdapter<Sample>(this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    mSamples));
        }

        @Override
        protected void onListItemClick(ListView listView, View view, int position, long id) {
            // Launch the sample associated with this list position.
            startActivity(new Intent(MainActivity.this, mSamples[position].activityClass));
        }
    }

