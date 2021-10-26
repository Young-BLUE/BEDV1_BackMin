package com.backmin.domains.store.domain;

import com.backmin.domains.menu.domain.MenuCategory;
import com.backmin.domains.review.domain.Review;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue
    @Column(name = "store_id")
    private Long id;

    @Column(name = "store_name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "min_oder_price")
    private int minOrderPrice;

    @Column(name = "min_deliv_time")
    private int minDelivTime;

    @Column(name = "max_deliv_time")
    private int maxDelivTime;

    @Column(name = "store_intro")
    private String storeIntro;

    @Column(name = "is_service")
    private boolean isService;

    @Column(name = "main_intro")
    private String mainIntro;

    @Column(name = "is_package")
    private boolean isPackage;

    @Column(name = "deliv_tip")
    private int delivTip;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuCategory> menuCategories = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private Category category;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
