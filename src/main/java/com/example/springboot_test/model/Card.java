package com.example.springboot_test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cardName;

    private CardTypeENUM cardTypeENUM;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "card_colors",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id"))
    private Set<Color> colors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "card_types",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "card_type_id"))
    private Set<CardType> cardTypes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "card_attributes",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "card_attribute_id"))
    private Set<CardAttribute> cardAttributes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "card_expansion_id")
    private CardExpansion cardExpansion;

    @ManyToOne
    @JoinColumn(name = "card_starter_deck_id")
    private StarterDeck cardStarterDeck;

    @ManyToOne
    @JoinColumn(name = "card_promotion_id")
    private CardPromotion cardPromotion;



}
