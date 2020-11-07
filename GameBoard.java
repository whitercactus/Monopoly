package com.company;

public class GameBoard {
    public static final int NUMBER_OF_PROPERTIES = 26;
    private Property[] properties = new Property[NUMBER_OF_PROPERTIES];

    public GameBoard() {
        properties[0] = new Property("Mediterranean avenue ", 600000, 20000);
        properties[1] = new Property("Baltic Avenue", 600000,40000);
        properties[2] = new Property("Reading railroad", 2000000,250000);
        properties[3] = new Property("Oriental Avenue", 1000000,60000);
        properties[4] = new Property("Vermont Avenue", 1000000,60000);
        properties[5] = new Property("Connecticut Avenue", 1200000, 8000000);
        properties[6] = new Property("St. Charles Place", 1400000, 100000);
        properties[7] = new Property("States Avenue", 1400000, 100000);
        properties[8] = new Property("Virginia Avenue",1600000,120000);
        properties[9] = new Property("St. james place",1800000, 140000);
        properties[10] = new Property("Pennsylvania Railroad",2000000, 250000);
        properties[11] = new Property("Tennessee Avenue",1800000,140000);
        properties[12] = new Property("New York Avenue",2000000,160000);
        properties[13] = new Property("Kentucky Avenue", 2200000, 180000);
        properties[14] = new Property("Indiana Avenue", 2200000, 180000);
        properties[15] = new Property("Illinois Avenue", 2400000, 200000);
        properties[16] = new Property("B.& O. Railroad",2000000,250000);
        properties[17] = new Property("Atlantic Avenue",2600000,220000);
        properties[18] = new Property("Ventor Avenue", 2600000,220000);
        properties[19] = new Property("Marvin Gardens", 2800000,240000);
        properties[20] = new Property("Pacific Avenue",3000000,260000);
        properties[21] = new Property("North Carolina Avenue", 3000000, 260000);
        properties[22] = new Property("Pennsylvania Avenue", 3200000, 80000);
        properties[23] = new Property("Short Line",2000000,250000);
        properties[24] = new Property("Park Place", 3500000, 350000);
        properties[25] = new Property("Boardwalk", 4000000,500000);
    }

    public Property getPropertyAt(int position) {
        return properties[position];
    }
}

