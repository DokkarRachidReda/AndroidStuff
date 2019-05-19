



private void loadIntoListView(String json) throws JSONException {
        //creating a json array from the json string
        JSONArray jsonArray = new JSONArray(json);
 
        //creating a string array for listview
        String[] heroes = new String[jsonArray.length()];
 
        //looping through all the elements in json array 
        for (int i = 0; i < jsonArray.length(); i++) {
            
            //getting json object from the json array
            JSONObject obj = jsonArray.getJSONObject(i);
            
            //getting the name from the json object and putting it inside string array 
            heroes[i] = obj.getString("name");
        }