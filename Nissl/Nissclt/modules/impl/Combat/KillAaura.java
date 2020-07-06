package me.Nissl.Nissclt.modules.impl.Combat;

import java.util.Random;
import java.util.UUID;
import java.util.Vector;

import org.lwjgl.input.Keyboard;
import net.minecraft.entity.Entity;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.Nissl.Nissclt.Nissclt;
import me.Nissl.Nissclt.events.EventPostMotionUpdate;
import me.Nissl.Nissclt.events.EventPreMotionUpdate;
import me.Nissl.Nissclt.events.EventUpdate;
import me.Nissl.Nissclt.modules.Category;
import me.Nissl.Nissclt.modules.Module;
import me.Nissl.Nissclt.modules.impl.Player.MidClick;
import me.Nissl.Nissclt.utils.TimeHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class KillAaura extends Module {

	private static float yaw, pitch;
	EntityLivingBase target;
	public TimeHelper time = new TimeHelper();
	int hitdelay = 3;
	static float maxangleyaw = 100;
	static float maxanglepitch = 100;
	static C03PacketPlayer pack;

	public KillAaura() {
		super("KillAura", "Killaura", Keyboard.KEY_M, 0x420202, Category.COMBAT);
	}

	public static void attack(EntityLivingBase e) {

		mc.playerController.attackEntity(mc.thePlayer, e);
		mc.thePlayer.swingItem();
		// mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(e,
		// C02PacketUseEntity.Action.ATTACK));
	}

	@EventTarget
	public void onPost(EventPostMotionUpdate event) {
		if (target != null && hasHit) {

			C03PacketPlayer p2 = new C03PacketPlayer.C05PacketPlayerLook(yaw, pitch, mc.thePlayer.onGround);
			mc.thePlayer.sendQueue.addToSendQueue(p2);

			hasHit = false;
		}
	}

	int delay = 0;
	static float[] angles;

	@EventTarget
	public void onPre(EventPreMotionUpdate event) {

		double d = mc.playerController.getBlockReachDistance();
		target = null;
		delay++;
		for (Object o : mc.theWorld.loadedEntityList) {
			if (o instanceof EntityLivingBase) {
				EntityLivingBase e = (EntityLivingBase) o;
				if (isAttackable(e)) {
					double dn = getDistance(e);
					if (dn < d) {
						target = e;
						d = dn;
					}
				}
			}

		}

		if (target != null) {
			if (delay >= hitdelay) {
				yaw = mc.thePlayer.rotationYaw;
				pitch = mc.thePlayer.rotationPitch;
				angles = getRotation(target);
				setRotation(angles[0], angles[1]);
				attack(target);
				hasHit = true;
				delay = 0;
			}

		}
	}

	public static double getDistance(EntityLivingBase entity) {
		final double diffX = entity.posX - mc.thePlayer.posX;
		final double diffZ = entity.posZ - mc.thePlayer.posZ;
		double diffY;

		if (entity instanceof EntityLivingBase) {
			final EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
			diffY = entityLivingBase.posY + entityLivingBase.getEyeHeight()
					- (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		} else {
			diffY = (entity.boundingBox.minY + entity.boundingBox.maxY) / 2.0D
					- (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		}

		final double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);

		return dist;
	}

	public static void setRotation(float y, float p) {

		pack = new C03PacketPlayer.C05PacketPlayerLook(y, p, mc.thePlayer.onGround);
		mc.thePlayer.sendQueue.addToSendQueue(pack);

	}

	public static float[] getRotation(EntityLivingBase entity) {

		final double diffX = entity.posX - mc.thePlayer.posX;
		final double diffZ = entity.posZ - mc.thePlayer.posZ;
		double diffY;

		final EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
		diffY = entityLivingBase.posY + entityLivingBase.getEyeHeight()
				- (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());

		final double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		final float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F;
		final float pitch = (float) -(Math.atan2(diffY, dist) * 180.0D / Math.PI);

		float[] angles = { yaw, pitch };
		return angles;

	}

	public static boolean isInAngle(EntityLivingBase entity) {
		return mc.thePlayer.canEntityBeSeen(entity);
	}

	public static boolean isAttackable(EntityLivingBase entity) {
		
		for(UUID e: midClickedPlayers) {
			if(e == entity.getUniqueID()) {
				return false;
			}
		}
		
		return entity != mc.thePlayer && entity.isEntityAlive()
				&& mc.thePlayer.getDistanceToEntity(entity) <= mc.playerController.getBlockReachDistance() - 0.5
				&& mc.thePlayer.canEntityBeSeen(entity);

	}

	@Override
	public void onEnable() {
		EventManager.register(this);
	}

	@Override
	public void onDisable() {
		EventManager.unregister(this);
	}

}
