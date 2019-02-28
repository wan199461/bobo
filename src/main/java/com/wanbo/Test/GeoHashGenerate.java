package com.wanbo.Test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import ch.hsr.geohash.GeoHash;

public class GeoHashGenerate {

    /** 日志. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GeoHashGenerate.class);

    /**
     * 
     * @param geohash String格式geohash块
     * @param x       边长
     * @return
     */
    public static GeoHashSquare squareGeoHash(String geohash, int x) {
        List<String> square = squareGeoHash(stringToGeo(geohash), x);
        return new GeoHashSquare(geohash, square);
    }

    /**
     * 
     * @param geohash
     * @return
     */
    public static GeoHash stringToGeo(String geohash) {
        return GeoHash.fromGeohashString(geohash);
    }

    /**
     * 以geoHash为中心点，获取周围以x为边长的正方形
     * 
     * @param geoHash 对象
     * @param x
     */
    public static List<String> squareGeoHash(GeoHash geohash, int x) {
        long start = System.currentTimeMillis();
        try {
//            List<GeoHash> crosswiseList = Lists.newArrayList(geohash);
            List<GeoHash> crosswiseList = new ArrayList<GeoHash>();
            crosswiseList.add(geohash);

            GeoHash left = null;
            GeoHash right = null;
            
            int floor = (int)Math.floor((x*1.0)/2);
//            int floor = Math.floorDiv(x, 2);
            for (int i = 0; i < floor; i++) {
                if (left == null || right == null) {
                    left = geohash.getWesternNeighbour();
                    right = geohash.getEasternNeighbour();
                } else {
                    left = left.getWesternNeighbour();
                    right = right.getEasternNeighbour();
                }
                crosswiseList.add(left);
                crosswiseList.add(right);
            }
            if (x % 2 == 0) {
                crosswiseList.remove(crosswiseList.size() - 1);
            }

//            List<GeoHash> g15x15List = Lists.newArrayList(crosswiseList);
            List<GeoHash> g15x15List = new ArrayList<GeoHash>();
            g15x15List.addAll(crosswiseList);

            for (GeoHash crosswise : crosswiseList) {
                GeoHash up = null;
                GeoHash below = null;
                for (int i = 0; i < Math.floorDiv(x, 2); i++) {
                    if (up == null || below == null) {
                        up = crosswise.getNorthernNeighbour();
                        below = crosswise.getSouthernNeighbour();
                    } else {
                        up = up.getNorthernNeighbour();
                        below = below.getSouthernNeighbour();
                    }
                    g15x15List.add(up);
                    g15x15List.add(below);
                }
                if (x % 2 == 0) {
                    g15x15List.remove(g15x15List.size() - 1);
                }

            }
//            List<String> geohashList = g15x15List.stream().map(geo -> geo.toBase32()).collect(Collectors.toList());
            List<String> geohashList = new ArrayList<String>();
            for (GeoHash ele : g15x15List) {
                geohashList.add(ele.toBase32());
            }

            LOGGER.info("[squareGeoHash]geohashList={}.", JSON.toJSONString(geohashList));
            return geohashList;
        } catch (Exception e) {
            LOGGER.error("[] exception. ", e);
            return null;
        } finally {
            LOGGER.info("[squareGeoHash] time consume={}", System.currentTimeMillis() - start);
        }
    }

    // 生成GeoHash的最终输出格式
    public static class GeoHashSquare {
        private String point; // 原始输入GeoHash块
        private List<String> square; // 扩展后的GeoHash区域

        public GeoHashSquare() {
            super();
        }

        public GeoHashSquare(String point, List<String> square) {
            super();
            this.point = point;
            this.square = square;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public List<String> getSquare() {
            return square;
        }

        public void setSquare(List<String> square) {
            this.square = square;
        }
    }

    public static void main(String... strings) {
        String geo = "wm3yvtb"; // wm3yvtb
        GeoHashSquare sq1 = squareGeoHash(geo, 15);
        GeoHashSquare sq2 = squareGeoHash("wm3yvtbb", 15);
        GeoHashSquare sq3 = squareGeoHash("wm3yvtbb5", 15);

        LOGGER.info(sq1.getSquare().size() + "  " + sq2.getSquare().size() + "   " + sq1.getSquare().size());
    }

}
