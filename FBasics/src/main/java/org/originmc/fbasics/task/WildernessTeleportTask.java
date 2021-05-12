package org.originmc.fbasics.task;

import lombok.Data;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.originmc.fbasics.settings.Settings;
import org.originmc.fbasics.settings.WildernessSettings;
import org.originmc.fbasics.util.MessageUtils;

@Data
public final class WildernessTeleportTask implements Runnable {

    private final Player player;

    private final Location location;

    private final WildernessSettings settings;

    @Override
    public void run() {
        player.teleport(location);

        // Inform the player the teleportation was a success.
        MessageUtils.sendMessage(player, settings.getSuccessMessage()
                .replace("{x}", "" + location.getBlockX())
                .replace("{y}", "" + location.getBlockY())
                .replace("{z}", "" + location.getBlockZ())
                .replace("{world}", location.getWorld().getName()));
    }

}
