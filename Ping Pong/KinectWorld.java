import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;


public abstract class KinectWorld extends World
{
    private final KinectClient kinect;
    private final double scale;

    
    public KinectWorld()
    {
        this(1.0, false);
    }

    
    public KinectWorld(double scale, boolean depth)
    {
        this(KinectClient.DEFAULT_IMAGE_WIDTH, KinectClient.DEFAULT_IMAGE_HEIGHT, scale, depth);
    }

    
    public KinectWorld(int thumbnailWidth, int thumbnailHeight, double scale, boolean depth)
    {
        super((int)(KinectClient.DEFAULT_IMAGE_WIDTH * scale), (int)(KinectClient.DEFAULT_IMAGE_HEIGHT * scale), 1); 

        this.scale = scale;

        kinect = new KinectClient(thumbnailWidth, thumbnailHeight, depth);
    }
    
    
    public void act()
    {
        if (isConnected())
            kinect.update();
    }
    
    
    public boolean isConnected()
    {
        return kinect.isConnected();
    }

    private UserData[] scaleUsers(UserData[] users)
    {
        for (int i = 0; i < users.length; i++)
            users[i] = users[i].scaledCopy((float)scale);
        return users;
    }

    
    public UserData[] getAllUsers()
    {
        if (kinect == null)
            return new UserData[0];
        else
            return scaleUsers(kinect.getUsers());
    }
    
   
    public UserData[] getTrackedUsers()
    {
        ArrayList<UserData> trackedUsers = new ArrayList<UserData>();
        for (UserData u : getAllUsers())
        {
            if (u.isTracking())
            {
                trackedUsers.add(u);
            }
        }
        // No need to scale, as getAllUsers will have already scaled:
        return trackedUsers.toArray(new UserData[0]);
    }
    
    
    public UserData getTrackedUser()
    {
        // No need to scale, as getAllUsers will have already scaled:
        for (UserData u : getAllUsers())
        {
            if (u.isTracking())
                return u;
        }
        
        return null;
    }
    
    
    public UserData getUser(int userId)
    {
        UserData u = kinect.getUser(userId);
        if (u != null)
            u = u.scaledCopy((float)scale);
        return u;
    }
    
    
    public GreenfootImage getThumbnail()
    {
        GreenfootImage img = getThumbnailUnscaled();
        if (img != null)
            img.scale((int)(scale * img.getWidth()), (int)(scale * img.getHeight()));
        return img;
    }

    
    public GreenfootImage getThumbnailUnscaled()
    {
        if (kinect == null)
            return null;
        else
            return kinect.getThumbnail();
    }
    
    
    public GreenfootImage getCombinedUserImage()
    {
        if (kinect == null)
            return null;
        else
        {
            GreenfootImage img = kinect.getCombinedUserImage();
            if (img != null)
                img.scale((int)(scale * img.getWidth()), (int)(scale * img.getHeight()));
            return img;
        }
    }

    
    public short getDepthAt(int x, int y)
    {
        if (kinect == null)
            return 0;

        short[] depthArray = kinect.getRawDepth();
        if (depthArray == null)
            return 0;

        int sy = (int)((double)y / scale);
        int sx = (int)((double)x / scale);
        int i = sy * 640 + sx;
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight() || i < 0 || i >= depthArray.length)
            return 0;
        return depthArray[i];
    }

    
    public short getMaxDepth()
    {
        if (kinect == null)
            return 0;
        else
            return kinect.getMaxDepth();
    }
    
    
    protected void disconnect()
    {
        kinect.disconnect();
    }
}
