package com.peak.fallacy.api;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.peak.fallacy.core.cca.entity.FollowerComponent;
import com.peak.fallacy.core.index.FallacyPatrons;
import com.peak.fallacy.core.index.FallacyRegistries;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@SuppressWarnings({"unused"})
public class Patron {
    private final Component name;
    private final Component title;
    private final Component slogan;

    private final boolean cursed;
    private final int color;

    public Patron(Component name, Component title, Component slogan, boolean cursed, int color) {
        this.name = name;
        this.title = title;
        this.slogan = slogan;

        this.cursed = cursed;
        this.color = color;
    }

    public Patron(Identifier id, boolean cursed, int color) {
        String base = "patron." + id.getNamespace() + "." + id.getPath();

        this.name = Component.translatable(base);
        this.title = Component.translatable(base + ".title");
        this.slogan = Component.translatable(base + ".slogan");

        this.cursed = cursed;
        this.color = color;
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

    public Component getSlogan() {
        return this.slogan;
    }

    public int getColor() {
        return this.color;
    }

    /// OVERRIDES
    public void tick(Player player, Level level) {}

    public void onAttack(Player player, LivingEntity target, Level level, InteractionHand hand) {}

    public void onUseKeybind(Player player, Level level) {}

    public void onSneak(Player player, Level level) {}

    public void onDamage(Player player, Level level, DamageSource source) {}

    public static final Codec<Patron> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ComponentSerialization.CODEC.optionalFieldOf("name", Component.empty()).forGetter(Patron::getName),
            ComponentSerialization.CODEC.optionalFieldOf("title", Component.empty()).forGetter(Patron::getTitle),
            ComponentSerialization.CODEC.optionalFieldOf("slogan", Component.empty()).forGetter(Patron::getSlogan),

            Codec.BOOL.optionalFieldOf("cursed", false).forGetter(Patron::isCursed),
            Codec.INT.optionalFieldOf("color", 0).forGetter(Patron::getColor)
    ).apply(instance, Patron::new));

    public static final StreamCodec<ByteBuf, Patron> PACKET_CODEC = ByteBufCodecs.fromCodec(CODEC);

    public static Patron getPatron(Player player) {
        FollowerComponent component = FollowerComponent.KEY.get(player);
        return component.getPatron();
    }

    public boolean isEmpty() {
        return this == FallacyPatrons.EMPTY;
    }
}
