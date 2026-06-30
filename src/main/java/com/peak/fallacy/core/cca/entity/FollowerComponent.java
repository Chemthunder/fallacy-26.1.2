package com.peak.fallacy.core.cca.entity;

import com.peak.fallacy.api.Patron;
import com.peak.fallacy.core.Fallacy;
import com.peak.fallacy.core.index.FallacyPatrons;
import com.peak.fallacy.core.index.FallacyRegistries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistryV3;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;

/**
 * @author Chemthunder
 */
@SuppressWarnings({"UnstableApiUsage"})
public class FollowerComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<FollowerComponent> KEY = ComponentRegistryV3.INSTANCE.getOrCreate(
            Fallacy.id("follower"),
            FollowerComponent.class
    );
    private final Player player;

    private Patron patron = FallacyPatrons.EMPTY;

    public FollowerComponent(Player player) {
        this.player = player;
    }

    public void tick() {
        if (this.patron != null) {
            this.patron.tick(player, player.level());
        }

        if (this.player.isCrouching() && this.player.tickCount % 5 == 0 && this.patron != null) {
            Fallacy.LOGGER.info("[{}]: Patron is {}", (this.player.level().isClientSide() ? "Client" : "Server"), FallacyRegistries.PATRON.getKey(this.patron));
        }
    }

    public void sync() {
        KEY.sync(this.player);
    }

    public void readData(ValueInput valueInput) {
       this.patron = valueInput.read("patron", Patron.CODEC).orElse(FallacyPatrons.EMPTY);
    }

    public void writeData(ValueOutput valueOutput) {
        valueOutput.store("patron", Patron.CODEC, this.patron);
    }

    public @Nullable Patron getPatron() {
        return patron;
    }

    public void setPatron(@Nullable Patron patron) {
        this.patron = patron;
        this.sync();
    }
}
