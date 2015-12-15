package com.nusclimb.live.crimp.common.json;

import com.nusclimb.live.crimp.common.Categories;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

/**
 * Response body for GET '/api/judge/categories'
 *
 * @author Lin Weizhi (ecc.weizhi@gmail.com)
 */
public class CategoriesResponseBody{
    @JsonProperty("categories")
    private ArrayList<Category> categories;

    public CategoriesResponseBody(){}

    public CategoriesResponseBody(CategoriesResponseBody mCategoriesResponseBody){
        categories = new ArrayList<Category>();
        for(Category c: mCategoriesResponseBody.getCategories()){
            categories.add(new Category(c));
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\tcategories: [\n");

        if(categories!=null) {
            if (categories.size() <= 1) {
                for (Category c : categories) {
                    sb.append("\t" + c.toString());
                }
            } else {
                sb.append("\t" + categories.get(0).toString());

                for (int i = 1; i < categories.size(); i++) {
                    sb.append(",\n");
                    sb.append("\t" + categories.get(i).toString());
                }
            }
        }
        else{
            sb.append("null");
        }
        sb.append("\t]\n");
        sb.append("}");

        return sb.toString();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public static class Category{
        @JsonProperty("category_name")
        private String categoryName;
        @JsonProperty("category_id")
        private String categoryId;
        @JsonProperty("routes")
        private ArrayList<Route> routes;
        @JsonProperty("scores_finalized")
        private boolean scoresFinalized;
        @JsonProperty("time_start")
        private String timeStart;
        @JsonProperty("time_end")
        private String timeEnd;

        public Category(){}

        public Category(Category category){
            categoryName = category.getCategoryName();
            categoryId = category.getCategoryId();
            scoresFinalized = category.isScoresFinalized();
            timeStart = category.getTimeStart();
            timeEnd = category.getTimeEnd();
            routes = new ArrayList<Route>();
            for(Route r: category.getRoutes()){
                routes.add(new Route(r));
            }
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("{\n");
            sb.append("\tcategory_name: '"+categoryName+"',\n");
            sb.append("\tcategory_id: '"+categoryId+"',\n");
            sb.append("\tscores_finalized: "+scoresFinalized+",\n");
            sb.append("\ttime_start: "+timeStart+",\n");
            sb.append("\ttime_end: "+timeEnd+",\n");
            sb.append("\troutes: [\n");
            if(routes!=null) {
                if (routes.size() <= 1) {
                    for (Route r : routes) {
                        sb.append(r.toString());
                    }
                } else {
                    sb.append(routes.get(0).toString());
                    for (int i = 1; i < routes.size(); i++) {
                        sb.append(",\n");
                        sb.append(routes.get(i).toString());
                    }
                }
            }
            else{
                sb.append("null");
            }
            sb.append("\t]\n");
            sb.append("}");

            return sb.toString();
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public ArrayList<Route> getRoutes() {
            return routes;
        }

        public void setRoutes(ArrayList<Route> routes) {
            this.routes = routes;
        }

        public boolean isScoresFinalized() {
            return scoresFinalized;
        }

        public void setScoresFinalized(boolean scoresFinalized) {
            this.scoresFinalized = scoresFinalized;
        }

        public String getTimeStart() {
            return timeStart;
        }

        public void setTimeStart(String timeStart) {
            this.timeStart = timeStart;
        }

        public String getTimeEnd() {
            return timeEnd;
        }

        public void setTimeEnd(String timeEnd) {
            this.timeEnd = timeEnd;
        }

        public static class Route{
            @JsonProperty("route_id")
            private String routeId;
            @JsonProperty("route_name")
            private String routeName;
            @JsonProperty("score")
            private String score;

            public Route(){}

            public Route(Route route){
                routeId = route.getRouteId();
                routeName = route.getRouteName();
                score = route.getScore();
            }

            @Override
            public String toString(){
                StringBuilder sb = new StringBuilder();
                sb.append("{\n");
                sb.append("\troute_id: "+routeId+",\n");
                sb.append("\troute_name: "+routeName+",\n");
                sb.append("\tscore: "+score+"\n");
                sb.append("}");

                return sb.toString();
            }

            public String getRouteId() {
                return routeId;
            }

            public void setRouteId(String routeId) {
                this.routeId = routeId;
            }

            public String getRouteName() {
                return routeName;
            }

            public void setRouteName(String routeName) {
                this.routeName = routeName;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }
        }
    }
}
