package org.originmc.fbasics.command;

import org.bukkit.command.CommandSender;
import org.originmc.fbasics.FBasics;

import static org.bukkit.ChatColor.*;

public final class CmdReload extends CommandExecutor {

    public static final String RELOAD_MESSAGE = "§8[§3Mineage§6Basics§8] §fConfig Reloaded";

    public CmdReload(FBasics plugin, CommandSender sender, String[] args, String permission) {
        super(plugin, sender, args, permission);
    }

    @Override
    public boolean perform() {
        long duration = System.currentTimeMillis();
        getPlugin().integrateFactions();
        getPlugin().integratePlaceholders();
        getPlugin().integrateVault();
        getPlugin().getSettings().load();
        getSender().sendMessage(RELOAD_MESSAGE.replace("{time}", String.valueOf(System.currentTimeMillis() - duration)));
        return true;
    }

}
