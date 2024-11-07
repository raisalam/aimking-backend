package com.cipher.aimkingbackend.utill;

public class Haversine {

    // Method to calculate the distance between two locations using Haversine formula
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Earth's radius in kilometers

        // Convert latitude and longitude from degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Haversine formula
        double dlat = lat2Rad - lat1Rad;
        double dlon = lon2Rad - lon1Rad;
        double a = Math.pow(Math.sin(dlat / 2), 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distance in kilometers
        return R * c;
    }

    // Method to parse coordinates from "latitude,longitude" format
    public static double[] parseCoordinates(String coordinates) {
        String[] parts = coordinates.split(",");
        double latitude = Double.parseDouble(parts[0].trim());
        double longitude = Double.parseDouble(parts[1].trim());
        return new double[] {latitude, longitude};
    }

    public static void main(String[] args) {
        // Example coordinates in "latitude,longitude" format
        String coord1 = "28.6519,77.2315";
        String coord2 = "28.4601,77.0263";

        // Parse coordinates
        double[] loc1 = parseCoordinates(coord1);
        double[] loc2 = parseCoordinates(coord2);

        // Calculate distance
        double distance = haversine(loc1[0], loc1[1], loc2[0], loc2[1]);
        System.out.println("Distance: " + distance + " km");
    }
}
