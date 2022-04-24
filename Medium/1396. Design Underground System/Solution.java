class UndergroundSystem {

    HashMap<Integer, String> checkIns;
    HashMap<String, String> pairs;
    public UndergroundSystem() {
        checkIns = new HashMap<Integer, String>();
        pairs = new HashMap<String, String>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, stationName + "-" + String.valueOf(t));
    }
    
    public void checkOut(int id, String endStation, int t) {
        String startStation = checkIns.get(id).split("-")[0];
        
        int startTime = Integer.parseInt(checkIns.get(id).split("-")[1]);
        int endTime = t;
        int currCount = 1;
        int currTime = endTime-startTime;
        if(pairs.containsKey(startStation+"-"+endStation)) {
            String[] values = pairs.get(startStation+"-"+endStation).split("-");
            currCount += Integer.parseInt(values[1]);
            currTime += Integer.parseInt(values[0]);
        }
        pairs.put(startStation+"-"+endStation, String.valueOf(currTime)+"-"+String.valueOf(currCount));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String values[] = pairs.get(startStation+"-"+endStation).split("-");
        return (double) Integer.parseInt(values[0]) / (double) Integer.parseInt(values[1]);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
