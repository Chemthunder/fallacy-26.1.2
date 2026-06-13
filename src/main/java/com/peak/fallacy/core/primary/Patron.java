package com.peak.fallacy.core.primary;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

@SuppressWarnings({"ClassCanBeRecord", "unused"})
public class Patron {
    private final Component name;
    private final Component title;
    private final boolean cursed;

    public Patron(Component name, Component title, boolean cursed) {
        this.name = name;
        this.title = title;
        this.cursed = cursed;
    }

    public boolean isCursed() {
        return this.cursed;
    }

    public Component getName() {
        return this.name;
    }

    public Component getTitle() {
        return this.title;
    }

    public void tick(Player player, Level level) {}

    public void onHit(Player player, LivingEntity target, Level level, InteractionHand hand) {}

    public void onUseKeybind(Player player, Level level) {}

    public static final Codec<Patron> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ComponentSerialization.CODEC.optionalFieldOf("name", Component.empty()).forGetter(Patron::getName),
            ComponentSerialization.CODEC.optionalFieldOf("title", Component.empty()).forGetter(Patron::getTitle),
            Codec.BOOL.optionalFieldOf("cursed", false).forGetter(Patron::isCursed)
    ).apply(instance, Patron::new));
}
