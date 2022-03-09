package com.mesum.ExploreMars;

class MarsModel {
   private String price ;
   private String id;
   private String type;
   private String img_src;

    public MarsModel(String price, String id, String type, String img_src) {
        this.price = price;
        this.id = id;
        this.type = type;
        this.img_src = img_src;
    }

    public MarsModel() {
    }

    @Override
    public String toString() {
        return "MarsModel{" +
                "price='" + price + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", img_src='" + img_src + '\'' +
                '}';
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }
}
