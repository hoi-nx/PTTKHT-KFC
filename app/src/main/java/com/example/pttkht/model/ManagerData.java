package com.example.pttkht.model;

import com.example.pttkht.model.objects.Category;
import com.example.pttkht.model.objects.FastFood;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Heart Of Dead on 11/1/2017.
 */

public class ManagerData {
    private static ManagerData managerData = new ManagerData();

    public static ManagerData getIntance() {
        return managerData;
    }
    public List<Category>getCategory(){
        List<Category>list=new ArrayList<>();
        list.add(new Category(1,"https://kfcvietnam.com.vn/uploads/category/combo/1ac6590fb77da1a8d688789b65880554.png","Phần Ăn Combo"));
        list.add(new Category(2,"https://kfcvietnam.com.vn/uploads/category/238f5ddc621cb7e65cebeaf2d08f1f32.png","Gà Rán & Gà Quay"));
        list.add(new Category(3,"https://kfcvietnam.com.vn/uploads/category/15e9593e800fcc33d043ab1e9a4b15b9.png","Burger-Cơm"));
        list.add(new Category(4,"https://kfcvietnam.com.vn/uploads/category/fff2f178b8c1e26be3ae9a6e96573223.png","Thức Ăn Nhẹ"));
        list.add(new Category(5,"https://kfcvietnam.com.vn/uploads/category/34bca7177ac0a46603ff20e0a8adf90b.png","Tráng Miệng Và Thức Uống"));
        return list;
    }

    public List<FastFood>getFastFood(int idCategory){
        List<FastFood>fastFoodList=new ArrayList<>();
        switch (idCategory){
            case 1:
                fastFoodList.add(new FastFood(1,"https://kfcvietnam.com.vn/uploads/combo/7a784575e34baa67ea608476beda88ec.jpg","Gà Rán Truyền Thống",79000));
                fastFoodList.add(new FastFood(2,"https://kfcvietnam.com.vn/uploads/combo/05276b952b9e7d1320763ff4b6a6fcb9.jpg","Phần ăn trẻ em",56000));
                fastFoodList.add(new FastFood(3,"https://kfcvietnam.com.vn/uploads/combo/d3219f6380fabb1561332e73c33c54be.jpg","Phần Ăn XL",99000));
                fastFoodList.add(new FastFood(4,"https://kfcvietnam.com.vn/uploads/combo/37a0cd4f10ad86332adb69b4d74e6f5c.jpg","Gà Quay Tiêu/Gà Big'n Jucicy",79000));
                fastFoodList.add(new FastFood(5,"https://kfcvietnam.com.vn/uploads/combo/fa297da80ab080684f5c90b6b6c568ce.jpg","Phần ăn teen's choice",63000));
                fastFoodList.add(new FastFood(6,"https://kfcvietnam.com.vn/uploads/combo/a6f768912bd3141c9d65277b7f47719d.jpg","Phần Ăn Double Meal",175000));
                fastFoodList.add(new FastFood(7,"https://kfcvietnam.com.vn/uploads/combo/b179cc1701e226350f6b95f6302a9e38.jpg","Phần Ăn Family Meal 3",245000));
                fastFoodList.add(new FastFood(8,"https://kfcvietnam.com.vn/uploads/combo/6ebd8915fd12ac097f8f6f957eff4c9b.jpg","Combo Chizz Dùng Thử",69000));
                fastFoodList.add(new FastFood(8,"https://kfcvietnam.com.vn/uploads/combo/12b4401a434bce91cbf2e66143abb73c.jpg","Combo Cho Một Người",79000));
                fastFoodList.add(new FastFood(9,"https://kfcvietnam.com.vn/uploads/combo/b179cc1701e226350f6b95f6302a9e38.jpg","Commbo Chizza A Cho 2 Người",136000));
                fastFoodList.add(new FastFood(10,"https://kfcvietnam.com.vn/uploads/combo/6ebd8915fd12ac097f8f6f957eff4c9b.jpg","Commbo Chizza B Cho 2 Người",136000));
                fastFoodList.add(new FastFood(11,"https://kfcvietnam.com.vn/uploads/combo/12b4401a434bce91cbf2e66143abb73c.jpg","Combo 49k-1",49000));
                fastFoodList.add(new FastFood(12,"https://kfcvietnam.com.vn/uploads/combo/afa5e34cdd25acd9add4f8b5b34a23ea.jpg","Combo 49k-2",49000));
                fastFoodList.add(new FastFood(13,"https://kfcvietnam.com.vn/uploads/combo/2b3e396cc1ebb5128d5866d5267d353a.jpg","Combo 89K-1",89000));
                fastFoodList.add(new FastFood(14,"https://kfcvietnam.com.vn/uploads/combo/28bf21925ab2f57029b31e7f61354a09.jpg","Combo 89K-2",89000));
                break;
            case 2:
                fastFoodList.add(new FastFood(15,"https://kfcvietnam.com.vn/uploads/product/be064003a56beabc4304bb9de7d63117.JPG","Gà truyền thống/ Gà Giòn cay (1 miếng)",34000));
                fastFoodList.add(new FastFood(16,"https://kfcvietnam.com.vn/uploads/product/b0914223717890b6e022cdda5bbf9157.JPG","Gà truyền thống/ Gà Giòn cay (3 miếng)",95000));
                fastFoodList.add(new FastFood(17,"https://kfcvietnam.com.vn/uploads/product/55e4aa27e3d2101a72871728c609f3fd.JPG","Gà truyền thống/ Gà Giòn cay (6 miếng)",184000));
                fastFoodList.add(new FastFood(18,"http://www.kfcvietnam.com.vn/asset/menu/2201_290715165156_ga-gion-cayjpg.jpg","Gà truyền thống/ Gà Giòn cay (9 miếng)",275000));
                fastFoodList.add(new FastFood(19,"http://www.kfcvietnam.com.vn/asset/menu/8519_290715165230_canh-ga-gion-cay-3-pcsjpg.jpg", "Cánh gà giòn cay (3 miếng)",47000));
                fastFoodList.add(new FastFood(20,"http://www.kfcvietnam.com.vn/asset/menu/4643_290715165304_canh-ga-gion-cayjpg.jpg", "Cánh gà giòn cay (5 miếng)",69000));
                fastFoodList.add(new FastFood(21,"http://www.kfcvietnam.com.vn/asset/menu/7390_290715165350_ga-quay-tieujpg.jpg", "Gà Quay Tiêu",64000));
                fastFoodList.add(new FastFood(22,"http://www.kfcvietnam.com.vn/asset/menu/3158_290715165418_ga-quay-giay-bacjpg.jpg", "Gà Quay Giay Bạc",64000));
                fastFoodList.add(new FastFood(23,"http://www.kfcvietnam.com.vn/asset/menu/7000_220817152034_556x4482.jpg", "Gà Xiên Que",31000));
                fastFoodList.add(new FastFood(24,"http://www.kfcvietnam.com.vn/asset/menu/5317_240817132954_556x4484.jpg", "Cánh Gà Giòn Cay Vị Tom Yum (3 miếng)",49000));
                fastFoodList.add(new FastFood(25,"http://www.kfcvietnam.com.vn/asset/menu/5139_240817133347_556x4482.jpg", "Cánh Gà Giòn Cay Vị Tom Yum (5 miếng)",71000));
                break;
            case 3:
                fastFoodList.add(new FastFood(26,"http://www.kfcvietnam.com.vn/asset/menu/9666_290715165758_burger-tomjpg.jpg", "Bơ-Gơ Tôm",39000));
                fastFoodList.add(new FastFood(27,"http://www.kfcvietnam.com.vn/asset/menu/4375_290715165822_burger-ga-quay-flavajpg.jpg", "Bơ-Gơ Gà Quay Flava",45000));
                fastFoodList.add(new FastFood(28,"http://www.kfcvietnam.com.vn/asset/menu/4496_290715165850_burger-zingerjpg.jpg", "Bơ-Gơ Zinger",49000));
                fastFoodList.add(new FastFood(29,"http://www.kfcvietnam.com.vn/asset/menu/6834_290715170050_com-ga-truyen-thongjpg.jpg", "Cơm Gà Truyền Thống KFC",39000));
                fastFoodList.add(new FastFood(30,"http://www.kfcvietnam.com.vn/asset/menu/5357_290715170120_com-phi-le-ga-quay-flavajpg.jpg", "Cơm phi-lê gà quay Flava",39000));
                fastFoodList.add(new FastFood(31,"http://www.kfcvietnam.com.vn/asset/menu/2319_290715170150_com-dui-ga-quay-flavajpg.jpg", "Cơm Đùi Gà Quay Tiêu",39000));
                fastFoodList.add(new FastFood(32,"http://www.kfcvietnam.com.vn/asset/menu/2558_220817151712_556x448.png", "Cơm Gà Xiên Que",39000));
                break;
            case 4:
                fastFoodList.add(new FastFood(33,"http://www.kfcvietnam.com.vn/asset/menu/2425_290715170423_ga-popcorn-rjpg.jpg", "Gà Viên (Vừa)",35000));
                fastFoodList.add(new FastFood(34,"http://www.kfcvietnam.com.vn/asset/menu/5489_290715170449_ga-popcornjpg.jpg", "Gà Viên (Lớn)",55000));
                fastFoodList.add(new FastFood(35,"http://www.kfcvietnam.com.vn/asset/menu/1800_290715170516_3-thanh-cajpg.jpg", "Cá Thanh(3 Miếng)",40000));
                fastFoodList.add(new FastFood(36,"http://www.kfcvietnam.com.vn/asset/menu/3262_290715170625_khoai-tay-chien-vuajpg.jpg", "Khoai Tây Chiên(Vừa)",12000));
                fastFoodList.add(new FastFood(37,"http://www.kfcvietnam.com.vn/asset/menu/7367_290715170658_khoai-tay-chien-lonjpg.jpg", "Khoai Tây Chiên(Lớn)",25000));
                fastFoodList.add(new FastFood(38,"http://www.kfcvietnam.com.vn/asset/menu/5299_290715170732_khoai-tay-chien-daijpg.jpg", "Khoai Tây Chiên(Đại)",35000));
                fastFoodList.add(new FastFood(39,"http://www.kfcvietnam.com.vn/asset/menu/6094_290715170808_khoai-tay-nghien-vuajpg.jpg", "Khoai Tây Nghiền(Vừa)",10000));
                fastFoodList.add(new FastFood(40,"http://www.kfcvietnam.com.vn/asset/menu/7271_290715170900_khoai-tay-nghien-lonjpg.jpg", "Khoai Tây Nghiền(Lớn)",20000));
                fastFoodList.add(new FastFood(41,"http://www.kfcvietnam.com.vn/asset/menu/9261_290715170930_khoai-tay-nghien-daijpg.jpg", "Khoai Tây Nghiền(Đại)",30000));
                fastFoodList.add(new FastFood(42,"http://www.kfcvietnam.com.vn/asset/menu/6044_290715170958_bap-cai-tron-vuajpg.jpg", "Bắp Cải Trộn(Vừa)",12000));
                fastFoodList.add(new FastFood(43,"http://www.kfcvietnam.com.vn/asset/menu/5308_290715171047_bap-cai-tron-lonjpg.jpg", "Bắp Cải Trộn(Lớn)",22000));
                fastFoodList.add(new FastFood(44,"http://www.kfcvietnam.com.vn/asset/menu/2794_290715171114_bap-cai-tron-daijpg.jpg", "Bắp Cải Trộn(Đại)",32000));
                fastFoodList.add(new FastFood(45,"http://www.kfcvietnam.com.vn/asset/menu/5711_290715171314_salad-gajpg.jpg", "Xà Lách Gà",19000));
                fastFoodList.add(new FastFood(46,"http://www.kfcvietnam.com.vn/asset/menu/5207_240817133912_556x4481.jpg", "Gà Viên Vị Tom Yum(Vừa)",37000));
                fastFoodList.add(new FastFood(47,"http://www.kfcvietnam.com.vn/asset/menu/824_240817134155_556x4483.jpg", "Gà Viên Vị Tom Yum(Lớn)",57000));
                break;
            case 5:
                fastFoodList.add(new FastFood(48,"http://www.kfcvietnam.com.vn/asset/menu/9385_290715171435_kem-sundaejpg.jpg", "Kem Sundae KFC ",12000));
                fastFoodList.add(new FastFood(49,"http://www.kfcvietnam.com.vn/asset/menu/5092_290715171533_kem-conejpg.jpg", "Kem Ốc Quế",4000));
                fastFoodList.add(new FastFood(50,"http://www.kfcvietnam.com.vn/asset/menu/2218_290715171557_kem-socolajpg.jpg", "Kem Phủ SÔ-CÔ-LA",6000));
                fastFoodList.add(new FastFood(51,"http://www.kfcvietnam.com.vn/asset/menu/8160_290715171905_aquafinajpg.jpg", "Bánh Trứng Nướng 1",15000));
                fastFoodList.add(new FastFood(52,"http://www.kfcvietnam.com.vn/asset/menu/6313_290715171843_pepsi-lonjpg.jpg", "Bánh Trứng Nướng 4",45000));
                fastFoodList.add(new FastFood(53,"http://www.kfcvietnam.com.vn/asset/menu/4769_290715172003_milojpg.jpg", "AQUAFINA",15000));
                fastFoodList.add(new FastFood(54,"http://www.kfcvietnam.com.vn/asset/menu/7012_290715172054_pepsi-lonjpg.jpg", "PEPSI(Lớn)",17000));
                fastFoodList.add(new FastFood(55,"http://www.kfcvietnam.com.vn/asset/menu/8292_290715172115_wisterjpg.jpg", "MILO(Vừa)",20000));
                fastFoodList.add(new FastFood(56,"http://www.kfcvietnam.com.vn/asset/menu/1456_290715172139_pepsi-vuajpg.jpg", "Diet PEPSI",17000));
                fastFoodList.add(new FastFood(57,"http://www.kfcvietnam.com.vn/asset/menu/2856_210817164537_556x448.jpg", "TWISTER",17000));
                fastFoodList.add(new FastFood(58,"http://www.kfcvietnam.com.vn/asset/menu/3518_220817104454_556x448.jpg", "PEPSI(Vừa)",10000));

                break;
        }
        return fastFoodList;
    }
    public FastFood getFood(int idFood,int idCatogery){
        for (FastFood fastFood:getFastFood(idCatogery)){
            if(idFood==fastFood.getIdFastFood()){
                return fastFood;
            }
        }
        return null;
    }


    public boolean saveOrderFood(Realm realm, final int idFood, final int idCategory, final int prices, final int number) {
        ShoppingCart orderFood = realm.where(ShoppingCart.class).equalTo("idFood", idFood).findFirst();
        if (orderFood != null) {
            return false;
        }
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ShoppingCart orderFood = new ShoppingCart(idFood,idCategory,(number*prices),number);
                realm.copyToRealm(orderFood);

            }
        });
        return true;
    }
    public RealmResults<ShoppingCart> getListOrderFood(Realm realm) {
        RealmResults<ShoppingCart> results = realm.where(ShoppingCart.class).findAll();
        return results;
    }

    public int getTotalPriceListOder(Realm realm){
        int tong=0;
        for(ShoppingCart shoppingCart:getListOrderFood(realm)){
            tong+=shoppingCart.getTotalPrices();
        }
        return tong;
    }
    public boolean updateOrderFood(Realm realm, final ShoppingCart orderFood, final int number, final int totalPrice) {
        ShoppingCart food = realm.where(ShoppingCart.class).equalTo("idFood", orderFood.getIdFood()).findFirst();
        if (food != null) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    orderFood.setNumber(number);
                    orderFood.setTotalPrices(totalPrice);
                }
            });
            return true;
        }
        return false;
    }

    public boolean deleteOrderFood(Realm realm, ShoppingCart orderFood) {
        ShoppingCart food = realm.where(ShoppingCart.class).equalTo("idFood", orderFood.getIdFood()).findFirst();
        if (food != null) {
            realm.beginTransaction();
            food.deleteFromRealm();
            realm.commitTransaction();
            return true;
        }
        return false;
    }
    public boolean clearAllListOrder(Realm mRealm) {
        final RealmResults<ShoppingCart> results = mRealm.where(ShoppingCart.class).findAll();
        if(results==null){
            return false;
        }
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                results.deleteAllFromRealm();

            }

        });
        return true;
    }
}
