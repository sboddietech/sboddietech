using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    public float speed;
    Camera cam;
    // Start is called before the first frame update
    void Start()
    {
        cam = GameObject.Find("Main Camera").GetComponent<Camera>();
    }

    // Update is called once per frame
    void Update()
    {
        float h = Input.acceleration.x;
        float v = Input.acceleration.y;

        Physics.gravity = new Vector3(h, 0, v) * speed;

        transform.forward = getScreenPosInWorld(Input.mousePosition) - transform.position;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    public float getSpeed()
    {
        return speed;
    }

    public Vector3 getScreenPosInWorld(Vector3 screenPos)
    {
        RaycastHit hitInfo;
        Ray r = cam.ScreenPointToRay(screenPos);
        if (Physics.Raycast(r, out hitInfo))
        {
            Vector3 hitSpot = hitInfo.point;
            hitSpot.y = 1;
            return hitSpot;
        }

        return Vector3.zero;
    }
}
