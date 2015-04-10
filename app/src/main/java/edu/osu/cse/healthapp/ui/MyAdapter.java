/*
 * Copyright 2014 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.osu.cse.healthapp.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import edu.osu.cse.healthapp.db.LogDO;
import healthapp.cse.osu.edu.healthapp.R;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

public class MyAdapter extends RealmBaseAdapter<LogDO> implements ListAdapter {

    private static class ViewHolder {
        TextView timestamp;
    }

    public MyAdapter(Context context, int resId, RealmResults<LogDO> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LogDO item = realmResults.get(position);
        convertView = inflater.inflate(R.layout.simple_result_row, parent, false);
        TextView textView1 = (TextView) convertView.findViewById(R.id.res_date);
        TextView textView2 = (TextView) convertView.findViewById(R.id.res_cc);
        TextView textView3 = (TextView) convertView.findViewById(R.id.res_cb);
        TextView textView4 = (TextView) convertView.findViewById(R.id.res_wi);
        TextView textView5 = (TextView) convertView.findViewById(R.id.res_w);
        textView1.setText(item.getDate());
        textView2.setText(""+item.getCalories_consumed());
        textView3.setText(""+item.getCalories_consumed());
        textView4.setText(""+item.getwater_intake());
        textView5.setText(""+item.getWeight());
        return convertView;

    }

    public RealmResults<LogDO> getRealmResults() {
        return realmResults;
    }
}
